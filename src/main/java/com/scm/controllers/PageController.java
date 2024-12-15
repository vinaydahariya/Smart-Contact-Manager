package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }

    // home route
    @RequestMapping("/home")
    public String home(Model model){
        // sending data to view
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("youtubeChannel", "Learn code with durgesh");
        model.addAttribute("githubRepo", "https://github.com/learncodewithdurgesh/");
        System.out.println("Home page handler");
        return "home";
    }

    // about route
    @RequestMapping("/about")
    public String aboutPage(){
        System.err.println("About page loading");
        return "about";
    }

    // services route
    @RequestMapping("/services")
    public String servicePage(){
        System.err.println("Services page loading");
        return "services";
    }

    // contact route
    @RequestMapping("/contact")
    public String contactPage(){
        System.out.println("Contact page loading");
        return "contact";
    }

    // login route
    @RequestMapping("/login")
    public String loginPage(){
        System.out.println("Login page loading");
        return "login";
    }

    // signup route
    @RequestMapping("/register")
    public String signupPage(Model model){
        UserForm userForm = new UserForm();
        // default data bhi daal sakte hai
        // userForm.setName("vinay");
        model.addAttribute("userForm", userForm);

        return "register";
    }

    // processing register
    @RequestMapping(value = "/do_register", method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, HttpSession session){
        System.out.println("Processing registration");
        // fetch form data
        // UserForm
        System.out.println(userForm);
        // validate form data
        if(bindingResult.hasErrors()){
            return "register";
        }

        // save to database
        
        

        // userservice
        // User user=User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber()); 
        user.setEnabled(false);
        user.setProfilePic("");

        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        // message = "Registration Successful"

        // add the message:

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);

        // redirectto login page
        return "redirect:/register";
    }

}
