package com.rod.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {

    private ArticleServiceImpl articleService; // AbstractService를 상속 받는 ArticleServiceImpl로 간다.

    public ArticleController() {
        articleService = ArticleServiceImpl.getInstance();
    }

    public List<?> findAll() throws SQLException {
        return articleService.findAll();
    }
}
