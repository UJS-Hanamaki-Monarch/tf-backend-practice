package org.tf.web.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tf.web.backend.entity.Login;
import org.tf.web.backend.service.HelloService;
import org.tf.web.backend.mapper.UserMapper;


@Service("helloService")
public class HelloServiceimpl implements HelloService {

    //似乎在DAO上加@Mapper就不会报错
    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean checkUserInfo(String username, String password) {
        Login login = userMapper.findByUsername(username);

      if (login == null)
            return false;
        else
            return password.equals(login.getPsw());
    }
}
