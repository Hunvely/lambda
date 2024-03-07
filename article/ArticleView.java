package article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleView {

    public static void main(Scanner input) throws SQLException {

        ArticleController articleController = new ArticleController();

        String menuSelect = input.next();
        while (true) {
            System.out.println("0 종료 | 1 글 목록");
            switch (menuSelect) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    List<?> articleList = articleController.articleList();
                    break;
            }

        }
    }
}
