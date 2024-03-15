package com.rod.api.menu;

import com.rod.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    @Getter
    private static final MenuService instance = new MenuServiceImpl();
    private final MenuRepository menuRepository;

    private MenuServiceImpl() {
        menuRepository = MenuRepository.getInstance();
    }

    @Override
    public Messenger createMenuTable() throws SQLException {
        menuRepository.createMenuTable();
        this.insertMenus();
        return Messenger.SUCCESS;
    }

    @Override
    public Messenger deleteMenuTable() throws SQLException {
        menuRepository.deleteMenuTable();
        return Messenger.SUCCESS;
    }

    @Override
    public List<?> getMenuByCategory(String category) throws SQLException {
        return menuRepository.getMenuByCategory(category);
    }

    private void insertMenus() {
        /**
         * 공통 메뉴 명령어 정의
         * x means 'Exit'
         * mk means 'Create Table'
         * cat means 'Find The One'
         * touch means 'Insert One'
         * ch-* means 'Change What'
         * rm means 'Delete Row'
         * ls-a means 'All List'
         * ls-n means 'Find By Name'
         * ls-* means 'Something List'
         * cnt means 'Count'
         * 이 외에 일상적이 아닌 단어는 약어 사용
         * withdraw -> with
         * deposit -> depo
         * balance -> bal
         * */
        String[] categories = {"navigate", "user", "account", "article", "board", "soccer"};
        String[][] menus = {{"x", "usr", "acc", "cwl", "art", "bbs", "scc"},
                {"x", "mk", "joi", "log", "cat", "ch-pw", "rm",
                        "ls-a", "ls-n", "ls-job", "cnt"},
                {"x", "mk", "touch", "with", "depo", "bal", "rm", "cat", "ls-a"},
                {"x", "mk"},
                {"x", "mk"},
                {"x", "mk"},};

        for (int i = 0; i < menus.length; i++)
            for (int j = 0; j < menus[i].length; j++)
                menuRepository.insertMenu(Menu.builder().category(categories[i]).item(menus[i][j]).build());
    }
}
