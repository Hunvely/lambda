package board;

import article.ArticleView;
import common.UtilService;
import common.UtilServiceImpl;
import freeboard.FreeBoardView;
import productboard.ProductBoardView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardView {

    public static void main(Scanner input) throws SQLException {

        while (true) {

            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1 - 자유게시판 이동\n " +
                    "2 - 상품게시판 이동\n " +
                    "3 - 글 적기 이동");
            System.out.print("메뉴 선택 : ");
            String menuselect = input.next();

            switch (menuselect) {
                case "0":
                    return;
                case "1":
                    System.out.println(" === 자유게시판으로 이동합니다. === ");
                    FreeBoardView.main(input);
                    System.out.println();
                    break;
                case "2":
                    System.out.println(" === 상품게시판으로 이동합니다. === ");
                    ProductBoardView.main(input);
                    System.out.println();
                case "3":
                    System.out.println(" === 글 목록 === ");
                    ArticleView.main(input);
                    System.out.println();
            }
        }
    }
}
