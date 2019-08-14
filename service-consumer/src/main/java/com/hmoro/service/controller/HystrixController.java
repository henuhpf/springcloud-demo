package com.hmoro.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
@Controller
@RequestMapping("consumer/hystrix")
@DefaultProperties(defaultFallback = "fallbackMethod") // 全局熔断方法
public class HystrixController {

    //    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    public HystrixController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    @ResponseBody
    @HystrixCommand // 声明被熔断的方法
//    @HystrixCommand (fallbackMethod = "queryUserByIdFallback")
    public String queryUserById(@RequestParam("id")Long id){
        if(id != 1){
            throw new RuntimeException();
        }
        return this.restTemplate.getForObject("http://service-provider/hystrix/" + id, String.class);
    }

//    public String queryUserByIdFallback(Long id){
//        return "服务器忙，请稍后再试!";
//    }

    public String fallbackMethod(){
        return "服务器忙，请稍后再试!";
    }
}
