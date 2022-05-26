package com.shareExp.backend.security;

import com.shareExp.backend.service.UserPrincipalDetailService;
import com.shareExp.backend.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@CrossOrigin(origins = "http://localhost:3000")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserPrincipalDetailService userPrincipalDetailService;
    private UserService userService;
    public SecurityConfiguration(UserPrincipalDetailService userPrincipalDetailService,
                                 UserService userService){
        this.userService = userService;
        this.userPrincipalDetailService = userPrincipalDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // filters:
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userService))
                // Authorizations:
                .authorizeRequests()
                .antMatchers("/login*").permitAll()
                .antMatchers("/api/account/create/**").permitAll()
                .antMatchers("/api/account/delete").authenticated()
                .antMatchers("/api/account/changePassword").authenticated()
                .antMatchers("/api/account/delete/**/**").hasRole("SUPERUSER")
        .antMatchers("/comment/s*").permitAll()
                .antMatchers( "/api/account/list/client/all").permitAll()
                .antMatchers("/api/exp/**").permitAll()
        .antMatchers("/api/categ/**").permitAll();


                /*.antMatchers("/api/services/hello").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/services/teacher/**").hasAuthority("auth1")
                .antMatchers("/api/services/hellos").hasRole("MANAGER")
                .antMatchers("/api/user/all").hasRole("ADMIN")
                .antMatchers("/api/user/withEmail").hasAnyRole("ADMIN MANAGER")
                .antMatchers("/api/user/withUserName").hasAnyRole("ADMIN MANAGER");*/
    }

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(this.userPrincipalDetailService);
        return authenticationProvider;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
