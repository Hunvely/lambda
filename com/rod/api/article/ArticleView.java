package com.rod.api.article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleView {

    public static void main(Scanner input) throws SQLException {

        ArticleController articleController = new ArticleController();

        while (true) {
            System.out.println("0 종료 | 1 글 목록");
            System.out.print(" 입력 : ");
            String menuSelect = input.next();
            switch (menuSelect) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println(" 1 - 글 목록");
                    articleController.findAll().forEach(i-> System.out.println(i));

                    break;
            }

        }
    }
}
