package org.community.service;

import org.community.domain.User;
import org.community.domain.UserExample;
import org.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frodoking on 2016/12/26.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAll() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    public User getById(Integer id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);

        List<User> users = userMapper.selectByExample(example);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

}
