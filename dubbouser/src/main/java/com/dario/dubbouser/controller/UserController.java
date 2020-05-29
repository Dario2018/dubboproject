package com.dario.dubbouser.controller;

import com.dario.dubbouser.condition.UserCondition;
import com.dario.dubbouser.dto.ResultVO;
import com.dario.dubbouser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userapi")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/","/login"})
    public String login(){
        return "login";
    }

    @ResponseBody
    @GetMapping("/queryAllUsers")
    public ResultVO queryAllUsers(@RequestBody UserCondition userCondition){
        return userService.queryAllUsers(userCondition);
    }
}
