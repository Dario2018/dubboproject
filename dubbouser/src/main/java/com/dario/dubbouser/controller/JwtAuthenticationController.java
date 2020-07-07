package com.dario.dubbouser.controller;

import com.dario.dubbouser.dto.LoginUserVO;
import com.dario.dubbouser.dto.ResultVO;
import com.dario.dubbouser.entity.User;
import com.dario.dubbouser.service.UserService;
import com.dario.dubbouser.utils.JwtTokenUtil;
import com.dario.dubbouser.dto.JwtUser;
import com.dario.dubbouser.dto.JwtResponse;
import com.dario.dubbouser.service.Impl.JwtUserDetailsService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 用于验证 jwt 返回客户端 jwt（json web token）
 */
@RestController("/auth")
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Value("${jwt.header}")
    private String tokenHeader;


    /**
     * 登录过程
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVO login(@RequestBody LoginUserVO userVO) throws Exception {

        if (Strings.isNullOrEmpty(userVO.getEmail()) || !(userVO.getEmail().contains("@") && userVO.getEmail().contains(".com"))) {
            return ResultVO.builder().message("邮箱为空或者不符合邮箱格式").code(HttpServletResponse.SC_BAD_REQUEST).build();
        }

        User userByEmail = userService.findUserByEmail(userVO.getEmail());
        if (userByEmail == null) {
            return ResultVO.builder().message(String.format("%s用户不存在", userVO.getEmail())).code(HttpServletResponse.SC_NOT_FOUND).build();
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(userVO.getPassword(), userByEmail.getPassword())) {
            return ResultVO.builder().message("登录密码不正确").code(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userByEmail.getUsername());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword()));
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResultVO.builder().code(HttpServletResponse.SC_OK).message("succeed").data(token).build();
    }

    /**
     * 获取 客户端来的 username password 使用秘钥加密成 json web token
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtUser authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(JwtResponse.builder().jwttoken(token).build());
    }

    /**
     * 获取 客户端来的 username password 使用秘钥加密成 json web token
     * authenticated 验证
     */
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}
