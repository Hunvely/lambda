package com.rod.api.enums;

import com.rod.api.article.ArticleController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public enum ArticleRouter {
    EXIT("0", (scanner, articleCtrl) -> {
        return false;
    }),
    ArticleList("1", (scanner, articlectrl) -> {
        System.out.println(" 1 - 글 목록");
        try {
            articlectrl.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    });

    private final String menuSelect;
    private final BiPredicate<Scanner, ArticleController> biPredicate;

    ArticleRouter(String menuSelect, BiPredicate<Scanner, ArticleController> biPredicate) {
        this.menuSelect = menuSelect;
        this.biPredicate = biPredicate;
    }

    public static boolean articleSelect(Scanner input, ArticleController artiCtrl) {
        System.out.println("0 종료 | 1 글 목록");
        System.out.print(" 입력 : ");
        String msg = input.next();
        return Stream.of(values())
                .filter(i -> i.menuSelect.equals(msg))
                .findAny().orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."))
                .biPredicate.test(input, artiCtrl);
    }
}
