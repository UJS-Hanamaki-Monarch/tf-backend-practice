package org.tf.web.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tf.web.backend.entity.User;
import org.tf.web.backend.service.HelloService;
import org.tf.web.backend.mapper.UserMapper;
import org.tf.web.backend.utils.ScurityUtil;



@Service("helloService")
public class HelloServiceimpl implements HelloService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean checkUserInfo(String username, String password) {
        User user = userMapper.findByUsername(username);

      if (user == null)
            return false;
        else
            return ScurityUtil.matchesPassword(password, user.getPsw());
    }

    @Override
    public User getUserByName(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
