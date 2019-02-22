package com.example.demo.redisservice;

import javax.servlet.http.HttpServletRequest;

public interface RedisService {
    public String get(String str);
    public boolean set(String str,String values);
    public String getIp();
}
