package article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {

    ArticleService articleService;

    public ArticleController() {
        articleService = ArticleServiceImpl.getInstance();
    }

    public List<?> articleList() throws SQLException {
        return articleService.articleList();
    }
}
