package com.myzg.gymnasium.controller;

import com.myzg.gymnasium.entity.LoginEntity;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
