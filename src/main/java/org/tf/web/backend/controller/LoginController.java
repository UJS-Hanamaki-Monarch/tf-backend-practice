package org.tf.web.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    String userName = "user1";
    String psw = "123456";

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
}
