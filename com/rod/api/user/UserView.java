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
            System.out.println("x.Exit\n" +
                    "1.Sign up\n" +
                    "2.Sigh in\n" +
                    "3.Search ID\n" +
                    "4.Update password\n" +
                    "5.Delete src.com.dennis.api.account\n" +
                    "ls.User list\n" +
                    "7.Search name\n" +
                    "8.Search job\n" +
                    "9.Number of users\n" +
                    "touch.Create table\n" +
                    "rm.Delete table");
            switch (input.next()) {
                case "0":
                    System.out.println("Exit");
                    return;
                case "1":
                    System.out.println("1.Sign up");
                    System.out.println(" | ID | Password | Name | PhoneNumber | Job | Height | Weight | ");
                    System.out.println(userController.save(input));
                    break;
                case "login":
                    System.out.println("2.Sigh in");
                    System.out.println(" | ID | Password | Input ");
                    System.out.println(userController.login(input));
                    break;
                case "3":
                    System.out.println("3.Search ID");
                    System.out.println(userController.getOne(input));

                    break;
                case "4":
                    System.out.println("4.Update password");
                    System.out.println(" | ID | Password | SSN | Input.");
                    System.out.println(userController.updatePassword(input));
                    break;
                case "5":
                    System.out.println("5 - 탈퇴");
                    System.out.println(" 탈퇴하실 ID를 입력하세요.");
                    System.out.println(userController.delete(input));
                    break;
                case "ls":
                    System.out.println("6.User list");
                    System.out.println("회원목록을 조회합니다.");
                    /*Map<String, ?> users = userController.getUserMap();
                    users.forEach((k, v) -> {
                        System.out.printf("아이디: %s, 회원정보: %s", k, v);
                    });*/
                    List<?> findUsers = userController.findUsers();
                    System.out.println(findUsers);
                    break;
                case "7":
                    System.out.println("7.Search name");
                    System.out.println(" 검색할 회원의 이름을 입력하세요");
                    userController.findUsersByName(input).forEach((i) -> {
                        System.out.println(i);
                    });
                    break;
                case "8":
                    System.out.println("8.Search job");
                    System.out.println(" 검색할 회원의 직업을 입력하세요");
                    userController.findUsersByJob(input).forEach((i) -> {
                        System.out.println(i);
                    });
                    break;
                case "9":
                    System.out.println("9.Number of users");
                    msg = userController.count();
                    System.out.println("회원 수 : " + msg + "명");
                    break;
                case "touch":
                    System.out.println("touch.Create table");
                    System.out.println(userController.createTable());
                    break;
                case "rm":
                    System.out.println("rm.Delete table");
                    System.out.println(userController.dropTable());
                    break;
            }
        }
    }
}