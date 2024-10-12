package com.minton.qapi.controller;

import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

import com.minton.qapi.client.QApiClient;
import com.minton.qapi.mapper.InterfaceInfoMapper;
import com.minton.qapi.mapper.UserMapper;
import com.minton.qapi.model.InterfaceInfo;
import com.minton.qapi.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/test")
public class TestController {

    private final UserMapper userMapper;
    private final InterfaceInfoMapper interfaceInfoMapper;

    public TestController(UserMapper userMapper, InterfaceInfoMapper interfaceInfoMapper) {
        this.userMapper = userMapper;
        this.interfaceInfoMapper = interfaceInfoMapper;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World!!!";
    }

    @GetMapping("/testDB")
    public String testDB() {
        List<User> user = userMapper.selectList(null);
        User user1 = userMapper.selectById(1);
        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectById(1L);
        System.out.println(interfaceInfo.getName() + interfaceInfo.getId());
        System.out.println(user1.getUsername());
        return JSONUtil.toJsonPrettyStr(user);
    }

    // use QApiClient to test PUT request
    @PutMapping("/testPut/{id}")
    public String testPut(@PathVariable Long id, @RequestBody User user) {
        QApiClient qApiClient = new QApiClient("your_api_key", "your_api_secret");
        HttpResponse response = qApiClient.sendRequest("PUT", "/users/" + id, JSONUtil.toJsonStr(user));
        return response.body();
    }

}