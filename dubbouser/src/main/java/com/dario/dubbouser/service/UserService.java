package com.dario.dubbouser.service;


import com.dario.dubbouser.condition.UserCondition;
import com.dario.dubbouser.dto.JwtUser;
import com.dario.dubbouser.dto.ResultVO;
import com.dario.dubbouser.entity.User;

public interface UserService {

    ResultVO queryAllUsers(UserCondition userCondition);


    public User findUserByEmail(String email) throws Exception;
}
