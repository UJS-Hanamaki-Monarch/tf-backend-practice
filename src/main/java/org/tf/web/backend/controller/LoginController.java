package org.tf.web.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.tf.web.backend.dto.LoginLzySuccess;
import org.tf.web.backend.dto.UserLzy;
import org.tf.web.backend.dto.UserRepository;

@RestController
public class LoginController {
    String userName = "user1";
    String psw = "123456";

    @Autowired // 自动装填
    private UserRepository userLZYRepositorys;

    @RequestMapping("/login")
    public UserLogin loginCheck(@RequestParam(value = "userName", defaultValue = "") String userName,
                      @RequestParam(value = "psw", defaultValue = "") String psw){
        boolean ifSuccess ;
        if (userName.equals(this.userName) && psw.equals(this.psw)){
            ifSuccess = true;
        }else {
            ifSuccess = false;
        }
        return new UserLogin(userName, ifSuccess);
    }

    @GetMapping("/lzy/login_mysql")
    public LoginLzySuccess loginMySQLCheck(@RequestParam String username, @RequestParam String password) {
        UserLzy userLZY = new UserLzy();
        LoginLzySuccess loginLzySuccess = new LoginLzySuccess();

        userLZY.setUsername(username);
        userLZY.setPassword(password);

        Integer id = userLZYRepositorys.findUserLzyForLogin(username, password);
        loginLzySuccess.setId(id);
        loginLzySuccess.setUsername(username);
        loginLzySuccess.setState("success");
        loginLzySuccess.setToken("ababa");
        return loginLzySuccess;
    }

    @GetMapping(path="lzy/all")
    public  String getAllUsers() {
        // This returns a JSON or XML with the users
//        return userLZYRepositorys.findAll();
        String s = userLZYRepositorys.queryByPassword("tuzi");
        return s;
    }

}
