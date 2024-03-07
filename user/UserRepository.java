package user;

import crawler.CrawlerRepository;

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

        String sql = "select * from board";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            do {
                System.out.printf("ID : %s\t Title : %s\t Conetnet : %s\t Writer : %s\n",
                        rs.getInt("id"),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
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
}
