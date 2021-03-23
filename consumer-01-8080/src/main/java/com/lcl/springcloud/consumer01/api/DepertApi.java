package com.lcl.springcloud.consumer01.api;

import com.lcl.springcloud.consumer01.dao.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepertApi {

    @Autowired
    private RestTemplate restTemplate;
    //private static final String provider_url = "http://localhost:8081";

    private static final String provider_url = "http://provider-depart";

    @PostMapping("/save")
    public boolean save(@RequestBody Depart depart){
        String url = provider_url + "/depart/save";
        return restTemplate.postForObject(url, depart, Boolean.class);
    }

    @PostMapping("/del")
    public boolean del(int id){
        String url = provider_url + "/depart/del";
        return restTemplate.postForObject(url, id, Boolean.class);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Depart depart){
        String url = provider_url + "/depart/update";
        return restTemplate.postForObject(url, depart, Boolean.class);
    }

    @GetMapping("/find/{id}")
    public Depart query(@PathVariable int id){
        String url = provider_url + "/depart/find/id";
        return restTemplate.getForObject(url, Depart.class);
    }

    @GetMapping("/findAll")
    public List<Depart> findAll(){
        String url = provider_url + "/depart/findAll";
        return restTemplate.getForObject(url, List.class);
    }
}
