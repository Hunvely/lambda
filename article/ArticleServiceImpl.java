package article;

import account.AccountServiceImpl;
import common.AbstractService;
import lombok.Getter;
import user.User;
import user.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    @Getter
    private static ArticleServiceImpl instance = new ArticleServiceImpl();
    private ArticleRepository articleRepository;

    public ArticleServiceImpl() {
        this.articleRepository = ArticleRepository.getInstance();
    }

    @Override
    public List<?> articleList() throws SQLException {
        return articleRepository.articleList();
    }
}
