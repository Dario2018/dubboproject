package com.dario.dubbouser.mapper;

import com.dario.dubbouser.condition.UserCondition;

import com.dario.dubbouser.entity.AuthUser;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserMapper{

    Page<AuthUser> queryAllUsers(UserCondition userCondition) throws Exception;

    AuthUser findUser(@Param("username") String username) throws Exception;

}