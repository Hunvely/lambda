package com.rod.api.user;

import java.util.Scanner;
import java.util.function.Predicate;

public enum UserRouter {
    su(
            "su",i ->{
        System.out.println("Sign up");
                return userController.save;
    }
    ),si,fi,up,da,ls,fn,fj,nou,touch,rm
    ;

    private final String menu;
    private final Predicate<Scanner, UserController> predicate;


    UserRouter(String menu, Predicate<Scanner> predicate, Predicate<Scanner, UserController> userCral) {
        this.menu = menu;
        this.predicate = predicate;
        this.userCral = userCral;
    }
}
