package com.rod.api.product;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @org.junit.jupiter.api.Test
    void systemOut() {
        Item item = new Item();
        String str1 = item.systemOut();
        System.out.println("-->" + str1);
        String str2 = "Hello";
        Assertions.assertEquals(item.systemOut(),"Hello");
    }

    @org.junit.jupiter.api.Test
    void add() {
        Item item = new Item();
        int sum = item.add(1,2);
        System.out.println("--->" + sum);
    }
}