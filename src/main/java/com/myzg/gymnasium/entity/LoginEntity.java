package com.myzg.gymnasium.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class LoginEntity {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

}
