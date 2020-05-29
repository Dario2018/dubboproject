package com.dario.dubbouser.service;


import com.dario.dubbouser.condition.UserCondition;
import com.dario.dubbouser.dto.ResultVO;

public interface UserService {

    ResultVO queryAllUsers(UserCondition userCondition);
}
