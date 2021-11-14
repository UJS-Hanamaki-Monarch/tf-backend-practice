package org.tf.web.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.tf.web.backend.dto.LoginDTO;
import org.tf.web.backend.service.HelloService;

import javax.validation.Valid;

@RestController
public class LoginController {
//    String userName = "user1";
//    String psw = "123456";

    @Autowired
    private HelloService helloService;

    @PostMapping("login")
    public String login(@Valid @RequestBody LoginDTO loginDTO, BindingResult result){
        if(result.hasErrors()){
            result.getAllErrors().forEach(objectError -> System.out.println(objectError.toString()));
            return "false";
        }
        if(helloService.checkUserInfo(loginDTO.getUsername(),loginDTO.getPassword())){
            return "success";
        }
        return "false";
    }

}
