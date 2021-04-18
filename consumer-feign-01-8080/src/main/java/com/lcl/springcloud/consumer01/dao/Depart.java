package com.lcl.springcloud.consumer01.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Depart {
    private Integer id;
    private String name;
}
