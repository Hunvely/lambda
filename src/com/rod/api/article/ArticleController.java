package com.rod.api.article;

import com.rod.api.user.UserController;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {

    @Getter
    private static final ArticleController istance = new ArticleController();

    private ArticleServiceImpl articleService; // AbstractService를 상속 받는 ArticleServiceImpl로 간다.

    public ArticleController() {
        articleService = ArticleServiceImpl.getInstance();
    }

    public List<?> findAll() throws SQLException {
        return articleService.findAll();
    }
}
