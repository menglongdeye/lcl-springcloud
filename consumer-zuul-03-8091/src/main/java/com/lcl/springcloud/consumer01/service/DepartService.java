package com.lcl.springcloud.consumer01.service;

import com.lcl.springcloud.consumer01.config.DepartFallBack;
import com.lcl.springcloud.consumer01.dao.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="pd", fallback= DepartFallBack.class)
@RequestMapping("/provider/depart")
@Service
public interface DepartService {
    @PostMapping("/save")
    boolean save(Depart depart);

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    List<Depart> findAll();

    @GetMapping("/find/{id}")
    Depart query(int id);
}
