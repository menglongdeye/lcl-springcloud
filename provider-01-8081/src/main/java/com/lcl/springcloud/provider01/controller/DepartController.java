package com.lcl.springcloud.provider01.controller;

import com.lcl.springcloud.provider01.dao.Depart;
import com.lcl.springcloud.provider01.service.DepartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/depart")
@Slf4j
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

    @GetMapping("/services")
    public void getServices(){
        List list = new ArrayList();
        List<String> services = client.getServices();
        for (String serviceNanme: services) {
            List<ServiceInstance> instances = client.getInstances(serviceNanme);
            for (ServiceInstance instance : instances) {
                log.info("instance.getHost()==================={}", instance.getHost());
                log.info("instance.getInstanceId()==================={}", instance.getInstanceId());
                log.info("instance.getServiceId()==================={}", instance.getServiceId());
                log.info("instance.getUri()==================={}", instance.getUri());
                log.info("instance.getMetadata()==================={}", instance.getMetadata());
                log.info("instance.getPort()==================={}", instance.getPort());
                log.info("instance.getScheme()==================={}", instance.getScheme());
            }
        }

    }

}
