package com.example.demo.redisservice.impl;

import com.example.demo.redisservice.RedisService;
import com.example.demo.utill.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;

@Service("RedisService")
public class RedisServiceImpl implements RedisService{

    @Autowired
    private RedisTemplate<String ,?> template;

    @Override
    public String get(String str) {
        String result = template.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = template.getStringSerializer();
                byte[] value = connection.get(serializer.serialize(str));
                return serializer.deserialize(value);
            }
        });
        return result;
    }

    @Override
    public boolean set(String str, String values) {
        boolean result=template.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = template.getStringSerializer();
                connection.set(serializer.serialize(str), serializer.serialize(values));
                return true;
            }
        });
        return result;
    }
    @Override
    public String getip(HttpServletRequest request) {
        String ip = IpUtil.getIpAddr(request);
        return ip;
    }

}
