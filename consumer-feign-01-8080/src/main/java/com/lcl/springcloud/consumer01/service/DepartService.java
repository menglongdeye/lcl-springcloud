package com.lcl.springcloud.consumer01.service;

import com.lcl.springcloud.consumer01.dao.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("pd")
@RequestMapping("/provider/depart")
public interface DepartService {
    @PostMapping("/save")
    boolean save(Depart depart);

    @PostMapping("/del")
    boolean del(int id);

    @PostMapping("/update")
    boolean update(Depart depart);

    @GetMapping("/find/{id}")
    Depart query(int id);

    @GetMapping("/findAll")
    List<Depart> findAll();

}
