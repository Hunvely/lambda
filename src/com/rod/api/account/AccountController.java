package com.rod.api.account;

import com.rod.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AccountController {

    @Getter
    private static final AccountController instancfe = new AccountController();
    AccountServiceImpl accountService;

    public AccountController() {
        this.accountService = AccountServiceImpl.getInstance();
    }

    public Messenger createAccountTable() throws SQLException {
        return accountService.createAccountTable();
        /*(Account.builder()
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build()
        );*/
    }

    public String deposit(Scanner sc) {
        return accountService.deposit(Account.builder()
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }

    public String withdraw(Scanner sc) {
        return accountService.withdraw(Account.builder()
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }

    public String getBalance(Scanner sc) {
        return accountService.getBalance(sc.next());
    }

    public String deleteAccount(Scanner sc) {
        return accountService.delete(Account.builder().accountNumber(sc.next()).build());
    }

    public List<?> getAccounts() {
        return accountService.findAll();
    }
}
