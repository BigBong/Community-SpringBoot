package org.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * Created by frodoking on 2017/1/19.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * This method configures the OAuth scopes required by clients to access all of the paths
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/web/freedom/**",
                        "/webjars/**", "/css/**", "/js/**", "/images/**",
                        "/oauth/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/web/login").permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/web/oauth2"));
    }
}
