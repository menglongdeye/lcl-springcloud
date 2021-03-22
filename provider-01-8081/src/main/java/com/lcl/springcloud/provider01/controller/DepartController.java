package com.lcl.springcloud.provider01.controller;

import com.lcl.springcloud.provider01.dao.Depart;
import com.lcl.springcloud.provider01.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartController {

    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public boolean save(Depart depart){
        return departService.save(depart);
    }

    @PostMapping("/del")
    public boolean del(int id){
        return departService.del(id);
    }

    @PostMapping("/update")
    public boolean update(Depart depart){
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
