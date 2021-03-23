package com.lcl.springcloud.provider01.service.impl;

import com.lcl.springcloud.provider01.dao.Depart;
import com.lcl.springcloud.provider01.dao.DepartRepository;
import com.lcl.springcloud.provider01.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository departRepository;

    @Override
    public boolean save(Depart depart) {
        Depart d = departRepository.save(depart);
        if(d != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean del(int id) {
        //如果id不存在，删除会报错
        if(departRepository.existsById(id)){
            departRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean update(Depart depart) {
        //这里save时，如果id为空，则新增；id不为空且id存在，则更新；id不为空且id不存在，仍然为新增，且id仍自动生成。
        Depart d = departRepository.save(depart);
        return d == null ? true:false;
    }

    @Override
    public Depart find(int id) {
        if(departRepository.existsById(id)){
            return departRepository.getOne(id);
        }
        return null;
    }

    @Override
    public List<Depart> findAll() {
        return departRepository.findAll();
    }
}
