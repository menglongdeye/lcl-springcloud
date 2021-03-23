package com.lcl.springcloud.provider01.controller;

import com.lcl.springcloud.provider01.dao.Depart;
import com.lcl.springcloud.provider01.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartController {

    @Autowired
    private DepartService departService;

    @Autowired  //声明服务发现客户端
    private DiscoveryClient client;

    @PostMapping("/save")
    public boolean save(@RequestBody Depart depart){
        return departService.save(depart);
    }

    @PostMapping("/del")
    public boolean del(int id){
        return departService.del(id);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Depart depart){
        return departService.update(depart);
    }

    @GetMapping("/find/{id}")
    public Depart query(@PathVariable int id){
        return departService.find(id);
    }

    @GetMapping("/findAll")
    public List<Depart> findAll(){
        return departService.findAll();
    }

}
