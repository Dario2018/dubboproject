package com.dario.dubbouser.service.Impl;

import com.dario.dubbouser.condition.UserCondition;
import com.dario.dubbouser.entity.AuthUser;
import com.dario.dubbouser.mapper.AuthUserMapper;
import com.github.pagehelper.Page;
import org.apache.curator.shaded.com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
* 登录验证过程
* */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (Strings.isNullOrEmpty(username)) {
            throw new UsernameNotFoundException("username must not be null");
        }
        try {
            AuthUser user = userMapper.findUser(username);
            // 后期完善授权(authorities)
            return new User(username, user.getPassword(), new ArrayList<>());
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found with username: " + username + ",message:" + e.getMessage());
        }
    }
}
