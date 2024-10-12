package com.minton.qapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minton.qapi.mapper.UserMapper;
import com.minton.qapi.model.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User createUser(User user) {
        userMapper.insert(user);
        return user;
    }

    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        user.setUpdatetime(new Date());
        userMapper.updateById(user);
        return user;
    }

    public void deleteUser(Long id) {
        userMapper.deleteById(id);
    }

}
