package com.csii.springcloud.controller;

import com.csii.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {
    //private static  final String REST_URL_PREFIX="http://localhost:8001";
    private static  final String REST_URL_PREFIX="http://MICRO-SERVER-DEPT";
    @Autowired
    private RestTemplate template ;

    /**
     * 使用restTemplate访问restful接口非常的简单粗暴无脑
     * （url,requestMap,ResponseBean.class这三个参数分别是REST请求地址，请求参数，HTTP响应转换被转换的对象类型）
     */

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept){

        return template.postForObject(REST_URL_PREFIX+"dept/add",dept,Boolean.class);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return template.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list(){
        return template.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }





}
