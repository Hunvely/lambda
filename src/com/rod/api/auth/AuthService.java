package com.rod.api.auth;

import com.rod.api.user.User;

import java.util.Map;
import java.util.Scanner;

public interface AuthService {

    public String join(Scanner input);

    public String login(Scanner input);

    String addUsers();

    User findUser(String username);

    Map<String, ?> getUserMap();

    String count();
}

