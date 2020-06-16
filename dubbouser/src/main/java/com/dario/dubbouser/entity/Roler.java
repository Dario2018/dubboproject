package com.dario.dubbouser.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class Roler implements Serializable {

    private static final Long serialVersionUID=5926468583005150708L;

    private Integer id;
    private String roleName; //角色名称
    private Integer userId;
}
