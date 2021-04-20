package com.lcl.springcloud.consumer01.config;

import com.lcl.springcloud.consumer01.dao.Depart;
import com.lcl.springcloud.consumer01.service.DepartService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class DepartFallBackFactory implements FallbackFactory<DepartService> {
    @Override
    public DepartService create(Throwable throwable) {
        return new DepartService() {
            @Override
            public boolean save(Depart depart) {
                log.info("=========执行保存异常服务降级处理========");
                return false;
            }

            @Override
            public List<Depart> findAll() {
                log.info("=========执行查询异常服务降级处理========");
                Depart arrays[] = {Depart.builder().id(0001).name("demo").build(), Depart.builder().id(0002).name("kkk").build()};
                return Arrays.asList(arrays);
            }
        };
    }
}
