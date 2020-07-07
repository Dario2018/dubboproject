package com.dario.dubbouser.mapper;

import com.dario.dubbouser.condition.UserCondition;

import com.dario.dubbouser.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Page<User> queryAllUsers(UserCondition userCondition) throws Exception;

    User findUserByUsername(@Param("username") String username) throws Exception;

    User findUserByEmail(@Param("email") String email) throws Exception;

}