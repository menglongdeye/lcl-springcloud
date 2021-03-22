package com.lcl.springcloud.provider01.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity //使用自动建表
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","fieldHandler"}) //使用懒加载
public class Depart {

    @Id //设置主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键自增长
    private Integer id;
    private String name;
}
