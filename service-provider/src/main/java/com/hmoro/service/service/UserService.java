package com.hmoro.service.service;

import com.hmoro.service.mapper.UserMapper;
import com.hmoro.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
