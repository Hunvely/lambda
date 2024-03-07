package user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner input) throws SQLException {
        UserController userController = new UserController();
        String msg = userController.addUsers();
        System.out.println(" addUsers 결과 : " + msg);
        while (true) {
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-회원가입\n " +
                    "2-로그인\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n " +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n " +
                    "8-직업검색\n " +
                    "9-회원수");
            switch (input.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("1-회원가입");
                    System.out.println(" | ID | Password | Name | SSN | PhoneNumber | Adress | Job | ");
                    System.out.println(userController.save(input));
                    break;
                case "2":
                    System.out.println("2-로그인");
                    System.out.println(" | ID | Password | 입력 ");
                    System.out.println(userController.login(input));
                    break;
                case "3":
                    System.out.println("3-회원의 ID를 검색합니다.");
                     System.out.println(userController.getOne(input));

                    break;
                case "4":
                    System.out.println("4-회원의 비밀번호를 변경합니다.");
                    System.out.println(" | ID | Password | 주민번호 | 를 입력하세요.");
                    System.out.println(userController.updatePassword(input));
                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    System.out.println(" 탈퇴하실 ID를 입력하세요.");
                    System.out.println(userController.delete(input));
                    break;
                case "6":
                    System.out.println("6-회원목록");
                    System.out.println("6-회원목록");
                    /*Map<String, ?> users = userController.getUserMap();
                    users.forEach((k, v) -> {
                        System.out.printf("아이디: %s, 회원정보: %s", k, v);
                    });*/
                    List<?> findUsers = userController.findUsers();
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    System.out.println(" 검색할 회원의 이름을 입력하세요");
                    userController.findUsersByName(input).forEach((i) -> {
                        System.out.println(i);
                    });
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    System.out.println(" 검색할 회원의 직업을 입력하세요");
                    userController.findUsersByJob(input).forEach((i) -> {
                        System.out.println(i);
                    });
                    break;
                case "9":
                    System.out.println("9-회원수");
                    msg = userController.count();
                    System.out.println("회원 수 : " + msg + "명");
                    break;

            }
        }
    }
}