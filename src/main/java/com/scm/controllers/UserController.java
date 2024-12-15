package com.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // user dashboard page
    @RequestMapping(value="/dashboard")
    public String userDashboard(){
        return "user/dashboard";
    }

    // user profile page
    @RequestMapping(value="/profile")
    public String userProfile(Model model, Authentication authentication){
        
        return "user/profile";
    }

    // user dashboard page
    @RequestMapping(value="/about")
    public String userAbout(){
        return "user/user_about";
    }

    // user dashboard page
    @RequestMapping(value="/services")
    public String userServices(){
        return "user/user_services";
    }

    // user dashboard page
    @RequestMapping(value="/contact")
    public String userContact(){
        return "user/user_contact";
    }

    
}
