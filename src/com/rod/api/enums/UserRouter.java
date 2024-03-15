package com.rod.api.enums;

import com.rod.api.menu.MenuController;
import com.rod.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {

    exit("x", (scanner) -> {
        return false;
    }),
    touch("mk", (scanner) -> {
        try {
            UserController.getInstance().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    signUp("joi", (scanner) -> {
        System.out.println("Input : | ID | Password | Name | PhoneNumber | Job | Height | Weight | ");
        try {
            UserController.getInstance().save(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }), signIn("log", (scanner) -> {
        UserController.getInstance().login(scanner);
        return true;
    }), searchId("cat", (scanner) -> {
        UserController.getInstance().getOne(scanner);
        return true;
    }), updatePassword("ch-pw", (scanner) -> {
        UserController.getInstance().updatePassword(scanner);
        return true;
    }), deleteAccount("rm", (scanner) -> {
        UserController.getInstance().delete(scanner);
        return true;
    }), userList("ls-a", ((scanner) -> {
        try {
            UserController.getInstance().findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    })), searchName("ls-n", (scanner) -> {
        UserController.getInstance().findUsersByName(scanner);
        return true;
    }), searchJob("ls-j", (scanner) -> {
        UserController.getInstance().findUsersByJob(scanner);
        return true;
    }), numberOfUsers("cnt", (scanner) -> {
        UserController.getInstance().count();
        return true;
    }),  rm("rm", (scanner) -> {
        try {
            UserController.getInstance().dropTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    });

    private final String menu;
    private final Predicate<Scanner> Predicate;

    UserRouter(String menu, Predicate<Scanner> Predicate) {
        this.menu = menu;
        this.Predicate = Predicate;
    }

    public static Boolean userRoute(Scanner input) throws SQLException {
        MenuController.getInstance().getMenuByCategory("user")
                .forEach(i -> System.out.print(i + " "));
        String msg = input.next();
        return Stream.of(values())
                .filter(i -> i.menu.equals(msg))
                .findAny().orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."))
                .Predicate.test(input);
    }


}
