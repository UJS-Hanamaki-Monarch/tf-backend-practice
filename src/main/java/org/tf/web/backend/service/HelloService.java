package org.tf.web.backend.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public Boolean checkUserInfo(String username, String password){
        return "admin".equals(username) && "123456".equals(password);
    }
}
