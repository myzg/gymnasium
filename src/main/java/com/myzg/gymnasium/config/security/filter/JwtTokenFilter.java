package com.myzg.gymnasium.config.security.filter;

import com.myzg.gymnasium.config.security.UserDetailServerImp;
import com.myzg.gymnasium.config.security.filter.exceptionHandle.AccessDeniedHandler;
import com.myzg.gymnasium.jwt.Const;
import com.myzg.gymnasium.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;


@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter{

    private UserDetailServerImp userDetailsService;
    private JwtUtils jwtUtils;

    public JwtTokenFilter(UserDetailServerImp userDetailsService,JwtUtils jwtUtils) {
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        httpServletRequest.setCharacterEncoding("UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        log.info(Thread.currentThread().getName());
        log.info("j---------------------------------进入过滤器");
        String token = httpServletRequest.getHeader(Const.TOKEN_HEADER);
        if(token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            String userName = jwtUtils.getUserNameFromToken(token);
            Collection authority =  jwtUtils.getAuthorityFromToken(token);
            if(!StringUtils.isEmpty(userName) && !CollectionUtils.isEmpty(authority)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(jwtUtils.getUserNameFromToken(token), null,authority);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


}
