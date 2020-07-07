package com.dario.dubbouser.service.Impl;

import com.dario.dubbouser.dto.JwtUser;
import com.dario.dubbouser.entity.User;
import com.dario.dubbouser.entity.Roler;
import com.dario.dubbouser.mapper.UserMapper;
import org.apache.curator.shaded.com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 登录验证过程
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (Strings.isNullOrEmpty(username)) {
            throw new UsernameNotFoundException("username must not be null");
        }
        try {
            User user = userMapper.findUserByUsername(username);
            List<SimpleGrantedAuthority> collect = user.getRolerList().stream().map(Roler::getRoleName).collect(Collectors.toList()).stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            return new JwtUser(user.getUsername(), user.getPassword(), user.getEmail(), user.getCompanyCode(), collect);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found with username: " + username + ",message:" + e.getMessage());
        }
    }
}
