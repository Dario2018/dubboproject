package com.dario.dubbouser.controller;

import com.dario.dubbouser.condition.UserCondition;
import com.dario.dubbouser.dto.ResultVO;
import com.dario.dubbouser.entity.User;
import com.dario.dubbouser.service.UserService;
import com.dario.dubbouser.utils.JwtTokenUtil;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @GetMapping("/queryAllUsers")
    public ResultVO queryAllUsers(@RequestBody UserCondition userCondition) {
        return userService.queryAllUsers(userCondition);
    }

    @GetMapping("/info")
    public ResultVO getInfo(String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        if (Strings.isNullOrEmpty(username)) {
            return ResultVO.builder().code(HttpServletResponse.SC_UNAUTHORIZED).message("Unauthorized").build();
        }
        try {
            User user = userService.findUserByUsername(username);
            if (user == null) {
                return ResultVO.builder().code(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).message("not found the account about " + username).build();
            }
            user.setPassword(null);
            return ResultVO.builder().code(HttpServletResponse.SC_OK).data(user).message("success").build();
        } catch (Exception e) {
            return ResultVO.builder().code(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).message(e.getMessage()).build();
        }
    }
}
