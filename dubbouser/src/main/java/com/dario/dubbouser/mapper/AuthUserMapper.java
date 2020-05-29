package com.dario.dubbouser.mapper;

import com.dario.dubbouser.condition.UserCondition;

import com.dario.dubbouser.entity.AuthUser;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface AuthUserMapper extends MyMapper<AuthUser> {

    Page<AuthUser> queryAllUsers(UserCondition userCondition) throws Exception;

}