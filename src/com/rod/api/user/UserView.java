package com.rod.api.user;

import com.rod.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner input) throws SQLException {
        UserController userController = new UserController();
        while (UserRouter.userRoute(input, userController)) ;

    }
}