package com.dario.dubbouser.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Data
public class JwtResponse implements Serializable {

    private static final Long serialVersionUID=-4926468583005150707L;

    private final String jwttoken;
}
