package com.example.educa.controller;



import com.example.educa.Entity.Menu;
import com.example.educa.services.MenuService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuController {

    private  MenuService menuService;

    public  MenuController(MenuService menuService) {
        super();
        this.menuService = menuService;
    }

    // handler method to handle list mwni and return mode and view
    @GetMapping("/menus")
    public String listMenu(Model model) {
        model.addAttribute("menu", menuService.getAllMenu());
        return "menus";
    }

    @GetMapping("/menus/new")
    public String createMenuForm(Model model) {

        // create menu object to hold mwnu form data
        Menu menu = new Menu();
        model.addAttribute("menu", menu);
        return "create_menu";

    }

    @PostMapping("/menus")
    public String saveMenu(@ModelAttribute("menu") Menu menu) {
        menuService.saveMenu(menu);
        return "redirect:/menus";
    }

    @GetMapping("/menus/edit/{id}")
    public String editMenuForm(@PathVariable Long id, Model model) {
        model.addAttribute("menu", menuService.getMenuById(id));
        return "edit_menu";
    }

    @PostMapping("/menus/{id}")
    public String updateMenu(@PathVariable Long id,
                                @ModelAttribute("menu") Menu menu,
                                Model model) {

        // get menu from database by id
        Menu existingMenu = menuService.getMenuById(id);
        existingMenu.setId(id);
        existingMenu.setName(menu.getName());
        existingMenu.setPrice(menu.getPrice());
        existingMenu.setStock(menu.getStock());

        // save updated menu object
        menuService.updateMenu(existingMenu);
        return "redirect:/menus";
    }

    // handler method to handle delete menu request

    @GetMapping("/menus/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuService.deleteMenuById(id);
        return "redirect:/menus";
    }

}
