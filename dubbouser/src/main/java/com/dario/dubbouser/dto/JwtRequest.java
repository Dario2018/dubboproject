package com.dario.dubbouser.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtRequest implements Serializable {

    private static final Long serialVersionUID=5926468583005150707L;

    private String username;

    private String password;

}
