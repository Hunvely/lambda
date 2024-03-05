package account;

import java.util.Scanner;

public class AccountView {
    public static void main(Scanner input) {
        AccountController accountController = new AccountController();
        while(true){
            System.out.println("[Account] 0-Exit 1-Create 2-Deposit " +
                    "3-Withdraw 4-Balance 5-Remove 6-Account List");
            switch (input.next()){
                case "0": return;
                case "1":
                    System.out.println("Create Account");
                    System.out.println(accountController.createAccount(input));
                    break;
                case "2":
                    System.out.println("Deposit");
                    System.out.println(accountController.deposit(input));
                    break;
                case "3":
                    System.out.println("Withdraw");
                    System.out.println(accountController.withdraw(input));
                    break;
                case "4":
                    System.out.println("Balance");
                    System.out.println(accountController.getBalance(input));
                    break;
                case "5":
                    System.out.println("Cancel Account");
                    System.out.println(accountController.deleteAccount(input));
                    break;
                case "6":
                    System.out.println("Account List");
                    accountController.getAccounts().forEach((i)-> {
                        System.out.println(i);
                    });
                    break;
            }
        }


    }
}
