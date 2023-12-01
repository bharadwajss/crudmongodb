/**
 * @author:Satish Bharatiya
 * @date: 12/1/2023
 */
package com.ssb.crudmongdb.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.ssb.crudmongdb.util.UserInformation.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends SecurityConfigurerAdapter {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       return
               httpSecurity.authorizeHttpRequests((authorize->{
                   authorize.anyRequest().authenticated();
               }))
                       .httpBasic(Customizer.withDefaults())
                       .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
         UserDetails testuser= User.builder().username(USERNAME)
                .password(passwordEncoder().encode(PASSWORD))
                .roles(ROLES).build();

       return  new InMemoryUserDetailsManager(testuser);
    }
}
