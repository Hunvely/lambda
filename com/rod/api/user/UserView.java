package com.rod.api.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner input) throws SQLException {
        UserController userController = new UserController();
        String msg = userController.addUsers();
        System.out.println(" addUsers 결과 : " + msg);
        while (true) {
            System.out.println("[사용자메뉴] [q] - 종료\n " +
                    "1 - 회원가입\n " +
                    "2 - 로그인\n " +
                    "3 - ID검색\n " +
                    "4 - 비번변경\n " +
                    "5 - 탈퇴\n " +
                    "[ls] - 회원목록\n " +
                    "7 - 이름검색\n " +
                    "8 - 직업검색\n " +
                    "9 - 회원수\n" +
                    "[touch] - 테이블 생성\n" +
                    "[rm] - 테이블 삭제\n"
            );
            switch (input.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "join":
                    System.out.println("1 - 회원가입");
                    System.out.println(" | ID | Password | Name | PhoneNumber | Job | Height | Weight | ");
                    System.out.println(userController.save(input));
                    break;
                case "login":
                    System.out.println("2 - 로그인");
                    System.out.println(" | ID | Password | 입력 ");
                    System.out.println(userController.login(input));
                    break;
                case "3":
                    System.out.println("3 - 회원의 ID를 검색합니다.");
                    System.out.println(userController.getOne(input));

                    break;
                case "4":
                    System.out.println("4 - 회원의 비밀번호를 변경합니다.");
                    System.out.println(" | ID | Password | 주민번호 | 를 입력하세요.");
                    System.out.println(userController.updatePassword(input));
                    break;
                case "5":
                    System.out.println("5 - 탈퇴");
                    System.out.println(" 탈퇴하실 ID를 입력하세요.");
                    System.out.println(userController.delete(input));
                    break;
                case "ls":
                    System.out.println("[ls] - 회원목록");
                    System.out.println("회원목록을 조회합니다.");
                    /*Map<String, ?> users = userController.getUserMap();
                    users.forEach((k, v) -> {
                        System.out.printf("아이디: %s, 회원정보: %s", k, v);
                    });*/
                    List<?> findUsers = userController.findUsers();
                    System.out.println(findUsers);
                    break;
                case "7":
                    System.out.println("7 - 이름검색");
                    System.out.println(" 검색할 회원의 이름을 입력하세요");
                    userController.findUsersByName(input).forEach((i) -> {
                        System.out.println(i);
                    });
                    break;
                case "8":
                    System.out.println("8 - 직업검색");
                    System.out.println(" 검색할 회원의 직업을 입력하세요");
                    userController.findUsersByJob(input).forEach((i) -> {
                        System.out.println(i);
                    });
                    break;
                case "9":
                    System.out.println("9 - 회원수");
                    msg = userController.count();
                    System.out.println("회원 수 : " + msg + "명");
                    break;
                case "touch":
                    System.out.println("[touch] - 테이블 생성");
                    userController.createTable();
                    System.out.println("회원테이블 생성 성공");
                    break;
                case "rm":
                    System.out.println("[rm] - 테이블 삭제");
                    userController.dropTable();
                    System.out.println("회원테이블 삭제 성공");
                    break;

            }
        }
    }
}