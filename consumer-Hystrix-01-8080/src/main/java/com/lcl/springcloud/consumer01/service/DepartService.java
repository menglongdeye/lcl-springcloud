package com.lcl.springcloud.consumer01.service;

import com.lcl.springcloud.consumer01.config.DepartFallBackFactory;
import com.lcl.springcloud.consumer01.dao.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value="pd", fallbackFactory= DepartFallBackFactory.class)
@RequestMapping("/provider/depart")
public interface DepartService {
    @PostMapping("/save")
    boolean save(Depart depart);

    @GetMapping("/findAll")
    List<Depart> findAll();
}
