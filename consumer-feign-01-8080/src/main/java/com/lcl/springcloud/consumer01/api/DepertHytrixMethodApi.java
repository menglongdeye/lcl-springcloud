package com.lcl.springcloud.consumer01.api;

import com.lcl.springcloud.consumer01.dao.Depart;
import com.lcl.springcloud.consumer01.service.DepartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hystrix")
public class DepertHytrixMethodApi {
    @Autowired
    private DepartService departService;

    @HystrixCommand(fallbackMethod = "hystrixDemo")
    @GetMapping("/findAll")
    public List<Depart> findAll(){
        return departService.findAll();
    }

    public List<Depart> hystrixDemo(){
        List<Depart> departList = new ArrayList<>();
        departList.add(Depart.builder().id(123).name("无数据").build());
        departList.add(Depart.builder().id(456).name("无数据").build());
        return departList;
    }
}
