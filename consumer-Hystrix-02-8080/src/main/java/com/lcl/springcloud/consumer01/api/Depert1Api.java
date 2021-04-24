package com.lcl.springcloud.consumer01.api;

import com.lcl.springcloud.consumer01.dao.Depart;
import com.lcl.springcloud.consumer01.service.DepartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/hystrix/depart")
public class Depert1Api {
    @Autowired
    private DepartService departService;

    @HystrixCommand(fallbackMethod = "failMethod", commandProperties = {@HystrixProperty(name="execution.isolation.strategy",value="SEMAPHORE")})
    @GetMapping("/findAll")
    public List<Depart> findAll(){
        return departService.findAll();
    }

    @HystrixCommand(fallbackMethod = "failMethod", commandProperties = {@HystrixProperty(name="execution.isolation.strategy",value="THREAD")})
    @GetMapping("/findAll2")
    public List<Depart> findAll2(){
        return departService.findAll();
    }

    public List<Depart> failMethod(){
        Depart arrays[] = {Depart.builder().id(123).name("abc").build(), Depart.builder().id(456).name("def").build()};
        return Arrays.asList(arrays);
    }
}
