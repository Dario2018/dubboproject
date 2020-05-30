package com.dario.dubbouser.condition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCondition {

    private String username;
    private Boolean isSuperuser;
    private  Integer pageNum;
    private Integer pageSize;
}
