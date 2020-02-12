package com.myzg.gymnasium.config.security;

import com.myzg.gymnasium.config.security.filter.JwtTokenFilter;
import com.myzg.gymnasium.config.security.filter.exceptionHandle.AccessDeniedHandler;
import com.myzg.gymnasium.config.security.filter.exceptionHandle.TokenExceptionHandler;
//import com.myzg.gymnasium.mapper.OperatorMapper;
import com.myzg.gymnasium.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailServerImp imp;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private TokenExceptionHandler tokenExceptionHandler;


    @Autowired
    private JwtUtils jwtUtils;

    public JwtTokenFilter jwtTokenFilter(UserDetailServerImp userDetailsService, JwtUtils jwtUtils) {
        return new JwtTokenFilter(userDetailsService,jwtUtils);
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST,"/login");
        web.ignoring().antMatchers(HttpMethod.GET,"/test");
        web.ignoring().antMatchers(HttpMethod.GET,"/druid/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //前后端分离不需要csrf 保护
        http.csrf().disable()
                //没有携带token 异常处理
                .exceptionHandling().authenticationEntryPoint(tokenExceptionHandler)
                .accessDeniedHandler(accessDeniedHandler).and()
                //基于token 不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                //所有方法都需要认证处理
                .antMatchers(HttpMethod.POST).authenticated()
                .antMatchers(HttpMethod.PUT).authenticated()
                .antMatchers(HttpMethod.DELETE).authenticated()
                .antMatchers(HttpMethod.GET).authenticated();
        //添加自定义filter
        http.addFilterAfter(jwtTokenFilter(imp,jwtUtils), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(imp).passwordEncoder(new BCryptPasswordEncoder());
    }
}
