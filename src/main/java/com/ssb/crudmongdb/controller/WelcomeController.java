/**
 * @author:Satish Bharatiya
 * @date: 12/1/2023
 */
package com.ssb.crudmongdb.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
@RequestMapping("/hello")
    public String hello(Authentication authentication){
        String username= authentication.getName();
        return "welcome "+username;
    }
}
