package com.lcl.springcloud.consumer01.api;

import com.lcl.springcloud.consumer01.dao.Depart;
import com.lcl.springcloud.consumer01.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepertApi {
    @Autowired
    private DepartService departService;

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
        return departService.query(id);
    }

    @GetMapping("/findAll")
    public List<Depart> findAll(){
        return departService.findAll();
    }
}
