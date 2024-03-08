package user;

import crawler.CrawlerRepository;
import enums.Messenger;

import java.sql.*;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserRepository getInstance() { // 정적 생성 메서드
        return instance;
    }

    private Connection connection;

    private UserRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb"
        );
    }

    public List<?> findUsers() throws SQLException {

        String sql = "select * from users";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            do {
                System.out.printf("ID : %s\t Username : %s\t Password : %s\t Name : %s\t Phone_number : %s\t Job : %s\t Height : %s\t Weight : %s\n",
                        rs.getInt("id"),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                System.out.println();
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }
        rs.close();
        pstmt.close();
        connection.close();

        return null;
    }

    public String createTable() throws SQLException {
        String sql = "CREATE TABLE users(                               \n" +
                "  id INT NOT NULL AUTO_INCREMENT,                 \n" +
                "  username VARCHAR(20) NOT NULL,                          \n" +
                "  password VARCHAR(20) NOT NULL,                      \n" +
                "  name  VARCHAR(30) NOT NULL, \n" +
                "  phone_number VARCHAR(20),\n" +
                "  job VARCHAR(20),\n" +
                "  height VARCHAR(20),\n" +
                "  weight VARCHAR(20),                                     \n" +
                "  CONSTRAINT users_pk PRIMARY KEY(id)             \n" +
                ");";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();

        return "회원테이블 생성";
    }

    public String dropTable() throws SQLException {
        String sql = "drop table users;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();


        return "회원테이블 삭제";
    }

    public Messenger save() throws SQLException {
        String sql = "INSERT INTO users(username,password,name,phone_number,job,height,weight) VALUES ('?','?','?','?','?','?','?')";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();

        return Messenger.SUCCESS;
    }
}
