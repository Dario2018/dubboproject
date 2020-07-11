package com.dario.dubbouser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*
* mybatis返回需要加上无参构造方法
* */
@Table(name = "wb_role")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Roler implements Serializable {

    private static final Long serialVersionUID = 5926468583005150708L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String roleName; //角色名称

    @Column(name = "role_type")
    private Integer roleType;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "create_time")
    private Date createTime;
}
