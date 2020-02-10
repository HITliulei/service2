package com.test.service2.controller;

import com.test.service2.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Lei
 * @Date 2020/2/9 16:45
 * @Version 1.0
 */
@RestController
@RequestMapping("/provider")
public class provider {

    @Value("${eureka.instance.metadata-map.version}")
    private String version;

    @GetMapping("/getTest")
    public User getUser(){
        User a = new User();
        a.setUsername("Asdf");
        a.setAge(12);
        return a;
    }


    @PostMapping("/postTest")
    public User postUser(@RequestBody User user){
        user.setAge(1000);
        return user;
    }


    @GetMapping("/getServiceInfo")
    public String getVersion(){
        return this.version;
    }


    @GetMapping("/only")
    public String only(){
        return "only 2.0 have";
    }
}
