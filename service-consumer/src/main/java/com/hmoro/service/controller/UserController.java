package com.hmoro.service.controller;

import com.hmoro.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("consumer/user")
public class UserController {

    //    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //    @Autowired
//    private DiscoveryClient discoveryClient;

    @GetMapping
    @ResponseBody
    public User queryUserById(@RequestParam("id")Long id){
//        User user = this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
//        return user;

//        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
//        ServiceInstance instance = instances.get(0);
//        User user = this.restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id, User.class);
        return this.restTemplate.getForObject("http://service-provider/user/" + id, User.class);
    }

}