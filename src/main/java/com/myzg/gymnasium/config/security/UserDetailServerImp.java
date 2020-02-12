package com.myzg.gymnasium.config.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myzg.gymnasium.entity.Operator;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;
import com.myzg.gymnasium.mapper.OperatorMapper;
import com.myzg.gymnasium.service.impl.OperatorServiceImpl;
import com.sun.tools.internal.ws.processor.ProcessorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UserDetailServerImp implements UserDetailsService{
    /** 操作员接口 **/
    @Autowired
    private OperatorServiceImpl service;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Operator loginOperator = null;
        try{
            loginOperator = service.getOne(new QueryWrapper<Operator>().eq("o_id", Integer.parseInt(s)));
        }catch (NumberFormatException e){
            log.error("传入的用户名错误，本次传入的格式是：{}",s);
            throw new ProgramException(ErrorEnum.ILLEGAL_ARGS,"用户名格式错误");
        }
        /** 这里因为数据中的密码已经通过加密，所以直接得到密码即可实现与前端输入的比对 **/
        if(loginOperator != null){
            List<GrantedAuthority> userAuthorities = new ArrayList<>();
            userAuthorities.add(new SimpleGrantedAuthority(loginOperator.getAuthority()));
            User sysUser = new User(loginOperator.getOId().toString(),loginOperator.getPassword(),userAuthorities);
            return sysUser;
        }
        throw new UsernameNotFoundException("User" + s + "not found");
    }

}
