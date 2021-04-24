package com.lcl.springcloud.consumer01.alarm;

import com.lcl.springcloud.consumer01.dao.Depart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class HystrixAlarm {

    private final String keySuffix = "_getDepart_fallback";
    private StringRedisTemplate template;
    private ForkJoinPool forkJoinPool = new ForkJoinPool(5);

    public Depart getHystrixHandle(HttpServletRequest request, int id){
        String ip = request.getLocalAddr();
        String key = ip +keySuffix;
        alarm(key);
        return Depart.builder().id(id).name("错误").build();
    }

    private void alarm(String key){
        BoundValueOperations<String, String> ops = template.boundValueOps(key);
        String value = ops.get();
        if(value == null){
            synchronized (this){
                value = ops.get();
                if(value == null){
                    sendMsgOrMail(key);
                    value = "已发生服务降级";
                    ops.set(value, 10, TimeUnit.SECONDS);
                }
            }
        }
    }

    private void sendMsgOrMail(String key){
        forkJoinPool.submit(()->{
            log.info("发送服务异常告警短信或邮件===={}", key);
        });
    }
}
