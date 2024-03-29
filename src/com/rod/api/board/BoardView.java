package com.rod.api.board;

import com.rod.api.article.ArticleView;
import com.rod.api.freeboard.FreeBoardView;
import com.rod.api.productboard.ProductBoardView;

import java.sql.SQLException;
import java.util.Scanner;

public class BoardView {

    public static void main(Scanner input) throws SQLException {

        while (true) {

            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1 - 자유게시판 이동\n " +
                    "2 - 상품게시판 이동\n " +
                    "3 - 글 목록 이동"); // 기능 출력 확인용. 삭제 예정
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
