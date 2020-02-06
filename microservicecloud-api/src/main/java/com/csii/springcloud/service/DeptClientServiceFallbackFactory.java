package com.csii.springcloud.service;

import com.csii.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("目前系统正在升级，测试服务降级").setDb_source("请稍后访问");
            }

            public List<Dept> list() {
                return null;
            }

            public Boolean add(Dept dept) {
                return null;
            }
        };
    }
}
