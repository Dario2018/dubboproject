package com.dario.dubbouser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LoginUserVO {

    private String password;

    private String email;
}
