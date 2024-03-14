package com.rod.api;

import com.rod.api.enums.NavigationOfFunction;
import com.rod.api.enums.NavigationOfPredicate;
import com.rod.api.enums.NavigationOfSuplier;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner input = new Scanner(System.in);
        while (NavigationOfPredicate.select(input)) ;
       // while(NavigationOfFunction.select(input).equals("x"));
        //while(NavigationOfSuplier.select(input).equals("x"));
    }
}