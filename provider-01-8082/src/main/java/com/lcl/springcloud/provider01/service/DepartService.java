package com.lcl.springcloud.provider01.service;

import com.lcl.springcloud.provider01.dao.Depart;

import java.util.List;

public interface DepartService {
    boolean save(Depart depart);

    boolean del(int id);

    boolean update(Depart depart);

    Depart find(int id);

    List<Depart> findAll();
}
