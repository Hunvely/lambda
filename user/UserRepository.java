package user;

import crawler.CrawlerRepository;

import java.sql.*;

public class UserRepository {

    private static UserRepository instance = new UserRepository();

    public static UserRepository getInstance() { // 정적 생성 메서드
        return instance;
    }

    public void findUsers() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/roddb";
        String userName = "roddb";
        String password = "roddb";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from board");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }

}
