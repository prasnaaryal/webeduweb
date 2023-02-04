package com.example.educa.services;

import com.example.educa.Entity.Menu;


import java.util.List;

public interface MenuService {
    List<Menu> getAllMenu();

    Menu saveMenu(Menu menu);

    Menu getMenuById(Long id);

    Menu updateMenu(Menu menu);

    void deleteMenuById(Long id);
}
