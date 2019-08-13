package com.hmoro.springboot.config;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
//@ConfigurationProperties(prefix = "user")
public class UserProperties {
    private String username;
    private int age;

}
