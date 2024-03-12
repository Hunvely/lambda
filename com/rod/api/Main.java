package com.rod.api;

import com.rod.api.account.AccountView;
import com.rod.api.article.ArticleView;
import com.rod.api.board.BoardView;
import com.rod.api.user.UserView;
import com.rod.api.crawler.CrawlerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("=== x-Exit " +
                    "u-User " +
                    "a-Article " +
                    "b-Board " +
                    "ac-Account " +
                    "c-Crawler " +
                    "===");
            String str = input.nextLine();

            switch (input.next()){
                case "x":  return;
                case "u": UserView.main(input);break;
                case "a": ArticleView.main(input);break;
                case "b": BoardView.main(input); break;
                case "ac": AccountView.main(input); break;
                case "c":  CrawlerView.main(input); break;
            }
        }
    }
}