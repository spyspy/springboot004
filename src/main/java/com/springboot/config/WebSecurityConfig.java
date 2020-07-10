package com.springboot.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

        auth.inMemoryAuthentication()     // 驗證資訊存放於記憶體
                .passwordEncoder(pwdEncoder)
                .withUser("admin")
                .password(pwdEncoder.encode("admin12345678"))
                .roles("ADMIN", "MEMBER")
                .and()
                .withUser("caterpillar")
                .password(pwdEncoder.encode("12345678"))
                .roles("MEMBER");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .loginPage("/login").permitAll();
//    }


}

/**
 *
 * Spring Security Tutorial
 *
 * Default Auto Configuration
 *
 * Ref: https://www.baeldung.com/spring-boot-security-autoconfiguration
 *
 *
 *
 *
 *
 *
 *
 * */