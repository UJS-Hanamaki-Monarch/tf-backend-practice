package org.tf.web.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author tuzi
 * @date 2021年11月21日 22:43
 */

@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll() // 放行所有权限
                .and()
                .csrf().disable(); // 相当于<security:csrf enabled=false/>标签
    }
}
