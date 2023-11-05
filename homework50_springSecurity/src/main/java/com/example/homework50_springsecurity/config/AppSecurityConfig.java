package com.example.homework50_springsecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/public").permitAll()
                .antMatchers(HttpMethod.POST, "/public").permitAll()
                .antMatchers("/private").authenticated()
                .antMatchers("/write").hasAuthority("write")
                .antMatchers("/read").hasAnyAuthority("write", "read")
                .and()
                .formLogin()
                .loginProcessingUrl("/myLogin")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.sendRedirect("/private");
                    }
                })
                .and()
                .logout()
                .logoutUrl("/mylogout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        request.getSession().invalidate();
                        response.sendRedirect("/public");
                    }
                })
                .and();
                //.httpBasic();
    }

  /*  @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("User1").password("1234").authorities("read")
                .and()
                .withUser("User2").password("12345").authorities("write")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }
}
