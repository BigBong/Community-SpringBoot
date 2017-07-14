package org.community.config;

import org.community.security.LoginSuccessHandler;
import org.community.service.OauthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by frodoking on 2017/1/14.
 * https://github.com/spring-guides/tut-spring-boot-oauth2/blob/master/auth-server/pom.xml
 * curl client:secret@localhost:8080/oauth/token -d grant_type=client_credentials -d scope=app
 * curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=pwd
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OauthUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // For example, if you wish to ignore certain requests.
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/webjars/**",
                "/**/favicon.ico", "/templates/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //所有的访问都需要权限验证
        http.authorizeRequests().anyRequest().authenticated();
        //访问失败页url
        http.formLogin().
                successHandler(loginSuccessHandler()).//登录信息保存
                defaultSuccessUrl("/").//访问成功页url
                loginPage("/login").permitAll().//默认访问页
                and().logout().permitAll();

        // 允许iframe 嵌套
        http.headers().frameOptions().disable();
        //关闭csrf 防止循环定向
        http.csrf().disable();
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return this.userDetailsService;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 用户或者管理员登录日志
     */
    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

}
