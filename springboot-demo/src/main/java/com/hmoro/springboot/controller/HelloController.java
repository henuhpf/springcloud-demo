package com.hmoro.springboot.controller;

import com.hmoro.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private User user;

    @GetMapping("show")
    public String test(){
        return "test";
    }

}
