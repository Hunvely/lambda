package com.rod.api.menu;

import com.rod.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {

    Messenger createMenuTable() throws SQLException;

    Messenger deleteMenuTable() throws SQLException;

    List<?> getMenuByCategory(String category) throws SQLException;

}
