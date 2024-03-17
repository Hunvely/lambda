package com.rod.api.account;

import com.rod.api.enums.AccountRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountView {
    public static void main(Scanner input) throws SQLException {
        AccountController accountController = new AccountController();
        while (AccountRouter.accountRoute(input)) ;

    }
}
