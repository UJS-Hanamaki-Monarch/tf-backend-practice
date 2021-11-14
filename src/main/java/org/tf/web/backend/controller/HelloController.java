package org.tf.web.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.tf.web.backend.dto.LoginDTO;
import org.tf.web.backend.service.HelloService;

import javax.validation.Valid;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello/{username}")
    public String hello(@PathVariable("username")String username){
        return "hello " + username + " !";
    }


}
