package com.hmoro.service.client;

import com.hmoro.service.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setUsername("服务器忙，请稍后再访问");
        return user;
    }

    @Override
    public User hystrixQueryUserById(Long id) {
        User user = new User();
        user.setUsername("服务器忙，请稍后再访问");
        return user;
    }
}
