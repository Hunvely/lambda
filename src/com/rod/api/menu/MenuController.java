package com.rod.api.menu;

import com.rod.api.enums.Messenger;
import lombok.Getter;

import java.util.List;

public class MenuController {
    @Getter
    private static final MenuController instance = new MenuController();
    private final MenuService menuService;

    private MenuController() {
        menuService = MenuServiceImpl.getInstance();
    }

    public Messenger makeMenuTable() {
        return menuService.makeMenuTable();
    }

    public Messenger removeMenuTable() {
        return menuService.removeTable();
    }

    public List<?> getMenusByCategory(String category) {
        return menuService.getMenusByCategory(category);
    }

}
