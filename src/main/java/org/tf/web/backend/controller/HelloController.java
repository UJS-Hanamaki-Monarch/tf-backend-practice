package org.tf.web.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tf.web.backend.service.HelloService;


@RestController
@RequestMapping("/hello")
public class HelloController {
    private HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/{username}")
    public String hello(@PathVariable("username")String username){
        return "hello " + username + " !";
    }
}
