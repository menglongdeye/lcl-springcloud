package com.lcl.springcloud.consumer01.api;

import com.lcl.springcloud.consumer01.dao.Depart;
import com.lcl.springcloud.consumer01.service.DepartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/hystrix/depart")
@Slf4j
public class DepertApi {
    @Autowired
    private DepartService departService;

    @GetMapping("/findAll")
    public List<Depart> findAll(){
        return departService.findAll();
    }

    @GetMapping("/list")
    public List<Depart> list(){
        return departService.findAll();
    }

    @GetMapping("/find/{id}")
    public Depart find(HttpServletRequest request, @PathVariable int id){
        return departService.query(id);
    }

    @GetMapping("/findAll2")
    public List<Depart> findAll(HttpServletRequest request){
        log.info("request.getHeader(\"Token\")========={}", request.getHeader("Token"));
        log.info("request.getHeader(\"Set-Cookie\")========={}", request.getHeader("Set-Cookie"));
        return departService.findAll();
    }
}
