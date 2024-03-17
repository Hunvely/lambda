package com.rod.api.enums;

import com.rod.api.account.AccountController;
import com.rod.api.menu.MenuController;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    EXIT("x", scanner -> {
        return false;
    }),
    CREATE_ACCOUNT("touch", scanner -> {
        System.out.println("Please input [account] [accountHolder] [balance] you wish to register");
        try {
            AccountController.getInstancfe().createAccountTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    DELETE_ACCOUNT("rm", scanner -> {
        AccountController.getInstancfe().deleteAccount(scanner);
        return true;
    }),
    DEPOSIT("depo", scanner -> {
        AccountController.getInstancfe().deposit(scanner);
        return true;
    }),
    WITHDRAW("with", scanner -> {
        AccountController.getInstancfe().withdraw(scanner);
        return true;
    }),
    BALANCE("bal", scanner -> {
        AccountController.getInstancfe().getBalance(scanner);
        return true;
    }),
    ACCOUNT_LIST("ls-a", scanner -> {
        AccountController.getInstancfe().getAccounts();
        return true;
    })
    ;

    private final String menuSelect;
    private final Predicate<Scanner> predicate;

    AccountRouter(String menuSelect, Predicate<Scanner> predicate) {
        this.menuSelect = menuSelect;
        this.predicate = predicate;
    }

    public static boolean accountRoute(Scanner input) throws SQLException {
        MenuController.getInstance().getMenuByCategory("account")
                .forEach(i -> System.out.print(i + " "));
        String msg = input.next();
        return Stream.of(values())
                .filter(i -> i.menuSelect.equals(msg))
                .findAny().orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."))
                .predicate.test(input);
    }
}
