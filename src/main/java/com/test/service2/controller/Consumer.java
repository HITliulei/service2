package com.test.service2.controller;

import com.test.service2.entity.User;
import com.test.service2.utils.MSendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Lei
 * @Date 2020/2/8 23:34
 * @Version 1.0
 */

@RequestMapping("/consumer")
@RestController
public class Consumer {

    @Autowired
    private MSendRequest mSendRequest;

    @GetMapping("/test11")
    public User f(){
        return mSendRequest.sendRequest("http://gateway/service1/userService/users/1","2.0.0", User.class, RequestMethod.GET);
    }
    @GetMapping("/test12")
    public User as(){
        return mSendRequest.sendRequest("http://gateway/service1/userService/users/1", User.class, RequestMethod.GET);
    }

    @GetMapping("/test13")
    public String asa(){
        User a = new User();
        a.setAge(1221);
        a.setName("afasdfasdf");
        a.setUsername("asdfkjhka");
        return mSendRequest.sendRequest("http://gateway/service1/userService/puttests","2.0.0", String.class, RequestMethod.PUT,a);
    }
}
