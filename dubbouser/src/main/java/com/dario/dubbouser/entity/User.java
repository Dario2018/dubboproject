package com.dario.dubbouser.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "wb_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private static final Long serialVersionUID = 5926468583005150708L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "is_superuser")
    private Boolean isSuperuser;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "is_staff")
    private Boolean isStaff;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "company_code")
    private String companyCode;

    @Column(name = "user_type")
    private Integer userType;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "nick_name")
    private String nickName;

    private List<Roler> rolerList;  //用户角色

}