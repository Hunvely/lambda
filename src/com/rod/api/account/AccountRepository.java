package com.rod.api.account;

import com.rod.api.enums.Messenger;

public class AccountRepository {

    private static AccountRepository instance;

    public AccountRepository() {
        instance = new AccountRepository();
    }
    public static AccountRepository getInstance(){
        return instance;
    }


    public Messenger save() {
        return null;
    }
}
