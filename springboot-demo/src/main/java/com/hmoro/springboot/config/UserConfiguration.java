package com.hmoro.springboot.config;


import com.hmoro.springboot.bean.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("classpath:user.properties")
//@EnableConfigurationProperties(UserProperties.class)
public class UserConfiguration {

//    @Autowired
//    private UserProperties userProperties;


/*    private UserProperties userProperties;

    public UserConfiguration(UserProperties userProperties) {
        this.userProperties = userProperties;
    }*/

 /*   @Bean
    public User user(UserProperties userProperties){
        User user = new User();
        user.setUsername(userProperties.getUsername());
        user.setAge(userProperties.getAge());
        return user;
    }*/

    @Bean
    @ConfigurationProperties(prefix = "user")
    public User user(){
        User user = new User();
        return user;
    }
}
