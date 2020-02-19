package com.myzg.gymnasium.service;


import com.myzg.gymnasium.config.security.UserDetailServerImp;
import com.myzg.gymnasium.entity.LoginEntity;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.responsebody.ResponseBody;
import com.myzg.gymnasium.service.impl.EmployeeServiceImpl;
import com.myzg.gymnasium.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private EmployeeServiceImpl employeeService;


    public ResponseBody findUser(LoginEntity entity) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(entity.getUserName(), entity.getPassword());
        final Authentication authentication = authenticationManager.authenticate(upToken);
        if(authentication.isAuthenticated()){
            final String token = jwtUtils.generateToken(authentication.getName(),authentication.getAuthorities());
            return ResponseBody.OK(token);
        }
        throw new ProgramException(ErrorEnum.ILLEGAL_ARGS,"账号/密码错误");
    }


    public ResponseBody getUserMessageByToken(String token) {
        String userName = jwtUtils.getUserNameFromToken(token);
        if(userName != null) {
            return ResponseBody.OK(new LoginEntity().setUserName(employeeService.getById(Integer.parseInt(userName)).getName()));
        }
        throw new ProgramException(ErrorEnum.ILLEGAL_ARGS,"token 错误请检查token");
    }

}
