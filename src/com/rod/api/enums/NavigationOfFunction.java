package com.rod.api.enums;

import com.rod.api.account.AccountView;
import com.rod.api.article.ArticleView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    Exit("x", scanner -> "x"),
    User("u", scanner -> {
        try {
            UserView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Article("a", scanner -> {
        try {
            ArticleView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Board("b", scanner -> {
        try {
            BoardView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Account("ac", scanner -> {
        AccountView.main(scanner);
        return "";
    }),
    Crawler("c", scanner -> {
        try {
            CrawlerView.main(scanner);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    });

    private final String menu;
    private final Function<Scanner, String> function;

    NavigationOfFunction(String menu, Function<Scanner, String> function) {
        this.menu = menu;
        this.function = function;
    }

    public static String select(Scanner input) {
        System.out.println("=== x-Exit " +
                "u-User " +
                "a-Article " +
                "b-Board " +
                "ac-Account " +
                "c-Crawler " +
                "===");
        String msg = input.next();
        return Stream.of(values())
                .filter(i -> i.menu.equals(msg))
                .findAny().orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다.")).function.apply(input);
    }
}
