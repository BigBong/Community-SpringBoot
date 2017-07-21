package org.community.controller.web;

import org.community.domain.User;
import org.community.entity.Message;
import org.community.service.AdminMenuService;
import org.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuwei19 on 2017/7/15.
 */
@Controller
@RequestMapping("/web/template")
public class TemplateController {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminMenuService adminMenuService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menuList(Model model) {
        model.addAttribute("menu", adminMenuService.adminMenuGroupList());
        return "fragments/menuFragment :: menu";
    }

    @RequestMapping(value = "/menu/profile", method = RequestMethod.GET)
    public String menuProfile(Model model) {
        model.addAttribute("user", getLoginUser());
        return "fragments/menuProfileFragment :: menuProfile";
    }

    @RequestMapping(value = "/nav/profile", method = RequestMethod.GET)
    public String navProfile(Model model) {
        model.addAttribute("user", getLoginUser());
        return "fragments/navProfileFragment :: navProfile";
    }

    @RequestMapping(value = "/nav/messages", method = RequestMethod.GET)
    public String navMessages(Model model) {
        model.addAttribute("messages", getMessages());
        return "fragments/navMessagesFragment :: navMessages";
    }

    private User getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return userService.getByName(currentPrincipalName);
    }

    private List<Message> getMessages() {
        List<Message> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Message message = new Message();
            message.user = getLoginUser();
            message.time = "3 mins ago";
            message.info = "Film festivals used to be do-or-die moments for movie makers. They were where...";
            list.add(message);
        }
        return list;
    }
}
