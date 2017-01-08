package org.community.api;

import org.community.service.UserService;
import org.community.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by frodoking on 2016/12/26.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> all() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public User view(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping("/user/add")
    public ResponseJsonWrapper<User> addUser(User user) {
        ResponseJsonWrapper<User> responseJsonWrapper = new ResponseJsonWrapper<>();
        responseJsonWrapper.setStatus(200);
        responseJsonWrapper.setMessage("");
        responseJsonWrapper.setData(null);

        int resultCode = userService.addUser(user);
        if (resultCode == 0) {
            User mUser = userService.getById(user.getId());
            if (mUser != null) {
                responseJsonWrapper.setData(mUser);
            } else {
                responseJsonWrapper.setMessage("添加不成功");
            }
        } else {
            responseJsonWrapper.setMessage("添加不成功");
        }
        return responseJsonWrapper;
    }
}
