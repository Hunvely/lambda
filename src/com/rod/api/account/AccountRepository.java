package com.rod.api.account;

import com.rod.api.enums.Messenger;

import java.sql.*;

public class AccountRepository {

    private static AccountRepository instance;

    public static AccountRepository getInstance(){
        return instance;
    }

    private PreparedStatement pstmt;
    private Connection conn;
    private ResultSet rs;
    private AccountRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb"
        );
    }


    public Messenger save() {
        return Messenger.SUCCESS;
    }

    public Messenger createAccountTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS accounts (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "accountNumber VARCHAR(30) NOT NULL," +
                "accountHolder VARCHAR(30) NOT NULL)" +
                "balance DOUBLE NOT NULL";
        pstmt = conn.prepareStatement(sql);
        int res = pstmt.executeUpdate();
        pstmt.close();

        return (res > 0 ) ? Messenger.SUCCESS : Messenger.FAIL;
    }
}
