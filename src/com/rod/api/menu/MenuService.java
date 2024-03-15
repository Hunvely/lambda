package com.rod.api.menu;

import com.rod.api.enums.Messenger;

import java.util.List;

public interface MenuService {
    Messenger makeMenuTable();

    Messenger removeTable();

    List<?> getMenusByCategory(String category);
}
