package org.tf.web.backend.service;

import org.springframework.stereotype.Service;

public interface HelloService {

    public Boolean checkUserInfo(String username, String password);
}
