package com.rod.api.article;

import com.rod.api.enums.ArticleRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {

    public static void main(Scanner input) throws SQLException {

        ArticleController articleController = new ArticleController();

        while (ArticleRouter.articleSelect(input));
    }
}
