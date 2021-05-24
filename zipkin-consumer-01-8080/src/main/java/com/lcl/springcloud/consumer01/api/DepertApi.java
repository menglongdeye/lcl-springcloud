package com.lcl.springcloud.consumer01.api;

import com.lcl.springcloud.consumer01.dao.Depart;
import com.lcl.springcloud.consumer01.service.DepartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depart")
@Slf4j
public class DepertApi {
    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public boolean save(@RequestBody Depart depart){
        log.info("consumer save 被调用");
        return departService.save(depart);
    }

    @PostMapping("/del")
    public boolean del(int id){
        log.info("consumer del 被调用");
        return departService.del(id);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Depart depart){
        log.info("consumer update 被调用");
        return departService.update(depart);
    }

    @GetMapping("/find/{id}")
    public Depart query(@PathVariable int id){
        log.info("consumer query 被调用");
        return departService.find(id);
    }

    @GetMapping("/findAll")
    public List<Depart> findAll() throws Exception {
        log.info("consumer findAll 被调用");
        return departService.findAll();
    }
}
