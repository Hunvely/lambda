package com.rod.api.menu;

import com.rod.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class MenuController {
    @Getter
    private static final MenuController instance = new MenuController();
    private final MenuService menuService;

    private MenuController() {
        menuService = MenuServiceImpl.getInstance();
    }

   public Messenger createMenuTable() throws SQLException {
        return menuService.createMenuTable();
   }

   public Messenger deleteMenuTable() throws SQLException {
        return menuService.deleteMenuTable();
   }

   public List<?> getMenuByCategory(String category) throws SQLException {
        return menuService.getMenuByCategory(category);
   }

  /*  public void printMenuCategory(String category) throws SQLException {
        System.out.println("[" + category + "]");
        System.out.println();
    }*/
}
