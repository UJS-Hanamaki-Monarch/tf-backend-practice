package org.tf.web.backend.service;

import org.springframework.stereotype.Service;
import org.tf.web.backend.entity.User;

public interface HelloService {

    public Boolean checkUserInfo(String username, String password);

    public User getUserByName(String username);

    public void insertUser(User user);
}
