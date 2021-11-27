package org.tf.web.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tf.web.backend.entity.User;
import org.tf.web.backend.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class HelloService {
    private final UserRepository userRepository;
    public Boolean checkUserInfo(String username, String password){
        User user = userRepository.getByUsernameAndPassword(username, password);
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }
}
