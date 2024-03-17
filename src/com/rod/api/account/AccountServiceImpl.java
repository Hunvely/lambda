package com.rod.api.account;

import com.rod.api.common.AbstractService;
import com.rod.api.enums.Messenger;
import com.rod.api.user.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountServiceImpl extends AbstractService<Account> implements AccountService {

    private static AccountServiceImpl instance = new AccountServiceImpl();
    private List<Account> accounts;
    private Map<String, User> users;
    private AccountRepository accountRepo;

    public AccountServiceImpl() {
        this.accounts = new ArrayList<>();
        accountRepo = AccountRepository.getInstance();
    }

    public static AccountServiceImpl getInstance() {
        return instance;
    }

    @Override
    public String deposit(Account account) {
        return null;
    }

    @Override
    public String withdraw(Account account) {
        return null;
    }

    @Override
    public String getBalance(String accountNumber) {
        return null;
    }

    @Override
    public Messenger save(Account account) {
        return accountRepo.save();
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Account> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Account account) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }


    public Messenger createAccountTable() throws SQLException {
        return accountRepo.createAccountTable();
    }
}
