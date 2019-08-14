package com.hmoro.service.controller;

import com.hmoro.service.client.UserClient;
import com.hmoro.service.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("consumer/hystrix")
//@DefaultProperties(defaultFallback = "fallbackMethod") // 全局熔断方法
public class HystrixController {
    @Autowired
    private UserClient userClient;

    @GetMapping
    @ResponseBody
//    @HystrixCommand // 声明被熔断的方法
//    @HystrixCommand (fallbackMethod = "queryUserByIdFallback")
    public User queryUserById(@RequestParam("id")Long id){
        return this.userClient.hystrixQueryUserById(id);
    }

//    public String queryUserByIdFallback(Long id){
//        return "服务器忙，请稍后再试!";
//    }

//    public String fallbackMethod(){
//        return "服务器忙，请稍后再试!";
//    }
}
