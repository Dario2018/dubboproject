package com.dario.dubbouser.service.Impl;

import com.dario.dubbouser.condition.UserCondition;
import com.dario.dubbouser.dto.JwtUser;
import com.dario.dubbouser.dto.ResultVO;
import com.dario.dubbouser.entity.User;
import com.dario.dubbouser.finallyValue.PageFinally;
import com.dario.dubbouser.mapper.UserMapper;
import com.dario.dubbouser.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVO queryAllUsers(UserCondition userCondition) {
        Optional<UserCondition> userConditionOptional = Optional.ofNullable(userCondition);
        PageHelper.startPage(userConditionOptional.map(UserCondition::getPageNum).orElse(PageFinally.PAGE_NUM),
                userConditionOptional.map(UserCondition::getPageSize).orElse(PageFinally.PAGE_SIZE));
        try {
            Page authUsers = userMapper.queryAllUsers(userCondition);
            PageInfo pageInfo = new PageInfo<>(authUsers);
            return ResultVO.builder().code(HttpServletResponse.SC_OK).data(pageInfo).build();
        } catch (Exception e) {
            return ResultVO.builder().code(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).message(e.getMessage()).build();
        }
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        return userMapper.findUserByEmail(email);
    }
}
