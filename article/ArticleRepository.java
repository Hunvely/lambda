package article;

import lombok.Getter;
import user.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    // 정적 생성 메서드
    @Getter
    private final static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection;

    private ArticleRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb"
        );
    }

    public List<?> findAll() throws SQLException {
        List<Article> ls = new ArrayList<>();

        String sql = "select * from articles";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        // 테이블 생성할 때 속성의 타입을 보고 'getXX'를 결정한다.
        if (rs.next()) {
            do {
                ls.add(Article.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .registerDate("register_date")
                        .build());
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }
        rs.close();
        pstmt.close();
        connection.close();
        return ls;
    }
}
