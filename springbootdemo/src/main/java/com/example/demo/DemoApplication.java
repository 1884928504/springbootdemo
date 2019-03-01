package com.example.demo;

import com.example.demo.redisservice.impl.RedisServiceImpl;
import com.example.demo.utill.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
//@ComponentScan(basePackages = {"com.example.demo.controller"})
@SpringBootApplication
public class DemoApplication{

    @Autowired
    private RedisServiceImpl redisService;

    @RequestMapping("/getUser/{key}")
    public String getUser(@PathVariable String key){
        String a = redisService.get(key);
        return a;
    }
    @RequestMapping("/setUser/{key}/{valu}")
    public boolean setUser(@PathVariable String key ,@PathVariable String valu){
        boolean c = redisService.set(key,valu);
        return c;
    }
    @RequestMapping(value = "/getIp")
    public String getIp(HttpServletRequest request) {
        String ip= IpUtil.getIpAddr(request);
        System.out.println(ip);
        return ip;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}


