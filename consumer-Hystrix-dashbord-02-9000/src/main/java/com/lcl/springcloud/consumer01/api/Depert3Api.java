package com.lcl.springcloud.consumer01.api;

import com.lcl.springcloud.consumer01.dao.Depart;
import com.lcl.springcloud.consumer01.service.DepartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/v3/hystrix/depart")
@Slf4j
public class Depert3Api {
    @Autowired
    private DepartService departService;

    @GetMapping("/findAll")
    public List<Depart> findAll(){
        return departService.findAll();
    }



}
