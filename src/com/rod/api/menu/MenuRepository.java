package com.rod.api.menu;

import com.rod.api.enums.Messenger;
import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    @Getter
    private static final MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private MenuRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
        pstmt = null;
        rs = null;
    }


    public Messenger insertMenu(Menu menu) {
        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getItem());
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getItem());
            return Messenger.SQL_ERROR;
        }
    }


    public Messenger createMenuTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS menus (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "category VARCHAR(10) NOT NULL," +
                "item VARCHAR(20) NOT NULL)";
        pstmt = conn.prepareStatement(sql);
        int res = pstmt.executeUpdate();
        pstmt.close();

        return (res > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger deleteMenuTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS menus";
        pstmt = conn.prepareStatement(sql);
        int res = pstmt.executeUpdate();
        pstmt.close();

        return (res > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

   /* public List<?> getMenuByCategory(String category) throws SQLException {
        List<Menu> ls = new ArrayList<>();
        String sql = "SELECT m.item FROM menus m WHERE category = ?";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                Menu menu = Menu.builder()
                        .item(rs.getString("item"))
                        .category(rs.getString("category"))
                        .build();
                ls.add(menu);
            } while (rs.next());
        } else {
            System.out.println("No Data");
        }
        return ls;
    }*/

    public List<?> getMenuByCategory(String category) throws SQLException {
        List<String> ls = new ArrayList<>();
        String sql = "SELECT m.item FROM menus m WHERE category = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, category);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                ls.add(rs.getString("item"));
            } while (rs.next());
        }
        else{
            System.out.println("No Date");
        }
        return ls;
    }
}
