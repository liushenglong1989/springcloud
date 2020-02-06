package com.csii.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * create DATABASE cloudDB01 CHARACTER set UTF8;
 *
 * CREATE table dept
 * (
 * deptno BIGINT not null PRIMARY key AUTO_INCREMENT,
 * dname varchar(60),
 * db_source varchar(60)
 * );
 *
 * INSERT into dept(dname,db_source) values ('开发部',DATABASE());
 * INSERT into dept(dname,db_source) values ('人事部',DATABASE());
 * INSERT into dept(dname,db_source) values ('运维部',DATABASE());
 * INSERT into dept(dname,db_source) values ('市场部',DATABASE());
 * INSERT into dept(dname,db_source) values ('财务部',DATABASE());
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept  implements Serializable {
    private Long deptno; //主键
    private String dname;//部门名称
    private String db_source; //来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库

}
