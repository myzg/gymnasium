package com.myzg.gymnasium.controller;


import com.myzg.gymnasium.config.security.UserDetailServerImp;
import com.myzg.gymnasium.entity.LoginEntity;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.LoginService;
import com.myzg.gymnasium.utils.JwtUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;
    // 登录
    @PostMapping(value = "/login")
    public ResponseBody login(@Validated @RequestBody LoginEntity entity) {
        return loginService.findUser(entity);
    }

    @GetMapping(value = "/login")
    public ResponseBody getUserInfo(@RequestParam String token) {
        return loginService.getUserMessageByToken(token);
    }

}
