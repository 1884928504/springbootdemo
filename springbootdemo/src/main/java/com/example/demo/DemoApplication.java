package com.example.demo;

import com.example.demo.redisservice.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
//@ComponentScan(basePackages = {"com.example.demo.controller"})
@SpringBootApplication
public class DemoApplication{


    @Autowired
    private RedisServiceImpl redisService;

    @RequestMapping("/getUser/{key}")
    public String getUser(@PathVariable String key,HttpServletRequest request){
        String ip = redisService.getip(request);
        Date date=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        boolean set = redisService.set(ip,time);
        String a = redisService.get(key);
        return a;
    }
    @RequestMapping("/setUser/{key}/{valu}")
    public boolean setUser(@PathVariable String key ,@PathVariable String valu,HttpServletRequest request){
        String ip = redisService.getip(request);
        Date date=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        boolean b = redisService.set(ip,time);
        boolean c = redisService.set(key,valu);
        if(!b&&c){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}


