package com.minton.qapi.user.controller;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import com.minton.qapi.interfaceInfo.mapper.InterfaceInfoMapper;
import com.minton.qapi.interfaceInfo.model.InterfaceInfo;
import com.minton.qapi.user.mapper.UserMapper;
import com.minton.qapi.user.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/test")
@Slf4j
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

//    @PutMapping("/testPut/{id}")
//    public String testPut(@PathVariable Long id, @RequestBody User user) {
//        log.info("testPut-------");
//        HttpResponse response = qApiClient.sendRequest("PUT", "/users/" + id, JSONUtil.toJsonStr(user));
//        log.info("response: {}", response.body());
//        return response.body();
//    }

}