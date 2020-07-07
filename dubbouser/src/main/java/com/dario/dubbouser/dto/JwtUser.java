package com.dario.dubbouser.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
@Builder
public class JwtUser implements UserDetails, Serializable {

    private static final Long serialVersionUID = 5926468583005150707L;

    private String username;

    private String password;

    private String email;

    private String companyCode;

    private Collection<? extends GrantedAuthority> authorities;  //用户角色权限结合

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // 账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账号是否被锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 密码是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
