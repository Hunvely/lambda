package com.rod.api.user;

import com.rod.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner input) throws SQLException {
        UserController userController = new UserController();
        String msg = userController.addUsers();
        System.out.println(" addUsers 결과 : " + msg);
        while (UserRouter.userRoute(input, userController)) ;

    }
}