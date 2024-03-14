package com.rod.api.enums;

import com.rod.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {

    exit("x", (scanner, ctrl) -> {
        return false;
    }),
    signUp("su", (scanner, ctrl) -> {
        System.out.println("Input : | ID | Password | Name | PhoneNumber | Job | Height | Weight | ");
        try {
            ctrl.save(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }), signIn("si", (scanner, ctrl) -> {
        ctrl.login(scanner);
        return true;
    }), searchId("fi", (scanner, ctrl) -> {
        ctrl.getOne(scanner);
        return true;
    }), updatePassword("up", (scanner, ctrl) -> {
        ctrl.updatePassword(scanner);
        return true;
    }), deleteAccount("da", (scanner, ctrl) -> {
        ctrl.delete(scanner);
        return true;
    }), userList("ls", ((scanner, ctrl) -> {
        try {
            ctrl.findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    })), searchName("fn", (scanner, ctrl) -> {
        ctrl.findUsersByName(scanner);
        return true;
    }), searchJob("fj", (scanner, ctrl) -> {
        ctrl.findUsersByJob(scanner);
        return true;
    }), numberOfUsers("nou", (scanner, ctrl) -> {
        ctrl.count();
        return true;
    }), touch("touch", (scanner, ctrl) -> {
        try {
            ctrl.createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }), rm("rm", (scanner, ctrl) -> {
        try {
            ctrl.dropTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    });

    private final String menu;
    private final BiPredicate<Scanner, UserController> biPredicate;

    UserRouter(String menu, BiPredicate<Scanner, UserController> biPredicate) {
        this.menu = menu;
        this.biPredicate = biPredicate;
    }

    public static Boolean userRoute(Scanner input, UserController userCtrl) {
        System.out.println("=== x.Exit\n" +
                "su.Sign up\n" +
                "si.Sigh in\n" +
                "fi.Search ID\n" +
                "up.Update password\n" +
                "da.Delete account\n" +
                "ls.User list\n" +
                "fn.Search name\n" +
                "fj.Search job\n" +
                "nou.Number of users\n" +
                "touch.Create table\n" +
                "rm.Delete table ===");
        String msg = input.next();
        return Stream.of(values())
                .filter(i -> i.menu.equals(msg))
                .findAny().orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."))
                .biPredicate.test(input, userCtrl);

    }


}
