package org.community.controller.web;

import org.community.menu.AdminMenu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by xuwei19 on 2017/7/15.
 */
@Controller
@RequestMapping("/web/template")
public class TemplateController {
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String showGuestList(Model model) {
        model.addAttribute("menu", getMenu());
        return "fragments/menuFragment :: menu";
    }

    private AdminMenu getMenu() {
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.groups = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            AdminMenu.Group group = new AdminMenu.Group();
            adminMenu.groups.add(group);
            group.name = "group 0" + (i + 1);
            group.groupItems = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                AdminMenu.GroupItem groupItem = new AdminMenu.GroupItem();
                group.groupItems.add(groupItem);
                groupItem.icon = "fa-home";
                groupItem.name = "GroupItem 0" + (j + 1);
                groupItem.items = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                    AdminMenu.Item item = new AdminMenu.Item();
                    groupItem.items.add(item);
                    item.name = "Item 0" + (k + 1);
                    item.url = "/web/user";
                }
            }
        }

        return adminMenu;
    }
}
