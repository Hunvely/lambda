package com.rod.api.article;

import com.rod.api.account.AccountServiceImpl;
import com.rod.api.common.AbstractService;
import com.rod.api.enums.Messenger;
import lombok.Getter;
import com.rod.api.user.User;
import com.rod.api.user.UserServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService implements ArticleService {

    @Getter
    private final static ArticleServiceImpl instance = new ArticleServiceImpl();
    private ArticleRepository articleRepository;

    public ArticleServiceImpl() {
        this.articleRepository = ArticleRepository.getInstance();
    }

    @Override
    public Messenger save(Object o) {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        List<?> ls = new ArrayList<>();
        ls = articleRepository.findAll();
        return ls;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
