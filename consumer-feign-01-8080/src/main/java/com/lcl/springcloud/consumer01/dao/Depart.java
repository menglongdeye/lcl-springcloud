package com.lcl.springcloud.consumer01.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class Depart {
    private Integer id;
    private String name;
}
