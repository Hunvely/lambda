package com.rod.api.enums;

import com.rod.api.account.AccountView;
import com.rod.api.article.ArticleView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum NavigationOfPredicate {

    EXIT("x", i -> {
        System.out.println("EXIT");
        return false;
    }),
    User("usr", i -> {
        System.out.println("User");
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Article("art", i -> {
        System.out.println("Article");
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Board("boa", i -> {
        System.out.println("Board");
        try {
            BoardView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Account("acc", i -> {
        System.out.println("Account");
        AccountView.main(i);
        return true;
    }),
    Crawler("crw", i -> {
        System.out.println("Crawler");
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    });

    private final String menu;
    private final Predicate<Scanner> predicate;

    NavigationOfPredicate(String menu, Predicate<Scanner> predicate) {
        this.menu = menu;
        this.predicate = predicate;
    }

    public static Boolean select(Scanner input) {
        System.out.println("=== x " +
                "usr " +
                "art " +
                "boa " +
                "acc " +
                "crw " +
                "===");
        String msg = input.next();
        return Stream.of(values())
                .filter(i -> i.menu.equals(msg))
                .findAny().orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."))
                .predicate.test(input);
    }
}
