package com.rod.api.enums;

import com.rod.api.article.ArticleController;
import com.rod.api.menu.MenuController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ArticleRouter {
    EXIT("x", (scanner) -> {
        return false;
    }),
    ArticleList("1", (scanner) -> {
        System.out.println(" 1 - 글 목록");
        try {
            ArticleController.getIstance().findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    });

    private final String menuSelect;
    private final Predicate<Scanner> predicate;

    ArticleRouter(String menuSelect, Predicate<Scanner> predicate) {
        this.menuSelect = menuSelect;
        this.predicate = predicate;
    }

    public static boolean articleSelect(Scanner input) throws SQLException {
        MenuController.getInstance().getMenuByCategory("article")
                .forEach(i-> System.out.print(i + " "));
        String msg = input.next();
        return Stream.of(values())
                .filter(i -> i.menuSelect.equals(msg))
                .findAny().orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."))
                .predicate.test(input);
    }
}
