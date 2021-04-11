package com.lcl.springcloud.provider01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 第一个泛型是操作的对象，第二个泛型是操作对象的主键类型
 */
public interface DepartRepository extends JpaRepository<Depart, Integer> {
}
