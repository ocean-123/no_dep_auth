package com.example.proj_auth_no_depn.Controller;


import com.example.proj_auth_no_depn.Entity.User;
import com.example.proj_auth_no_depn.Repo.UserRepo;
import com.example.proj_auth_no_depn.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller

public class UserController {

@Autowired
    UserService userService;

@Autowired
    UserRepo userRepo;

    @ModelAttribute
    public void commonUser(Principal p, Model m) {
        if (p != null) {
            String email = p.getName();
            User user = userRepo.findByEmail(email);
            m.addAttribute("user", user);
        }
    }


    @GetMapping("/")

    public  String home(){
        return "index";
    }



    @GetMapping("/signin")
    public String login(){

        return "login";
    }

    @GetMapping("/signup")
    public String register(){

        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, HttpSession session, Model m) {

        // System.out.println(user);
        if (userRepo.existsByEmail(user.getEmail())) {
            session.setAttribute("message", "Email already exists");
            return "register";
        }





        // Check if any required fields are empty
        if ( user.getFirst_name().isEmpty() || user.getLast_name().isEmpty()
                || user.getEmail().isEmpty() || user.getPhone().isEmpty()
                || user.getPassword().isEmpty() ) {
            session.setAttribute("message", "All fields are required");
            return "register";
        }



        // Check if the email

//        if(!user.getEmail().matches("^[a-z0-9]+@[a-z0-9]+\\.(gmail|yahoo|outlook)\\.(com|in|edu)$"
//
//        )){
//            session.setAttribute("message","your email is invalid");
//            return "register";
//        }


        // Check if the password is within the allowed length and should be alphanumeric
        if (user.getPassword().length() > 20 || user.getPassword().length() < 6|| !user.getPassword().matches("^[a-zA-Z0-9]+$")  )  {
            session.setAttribute("message", "Password must be between 6 and 20 characters with alpha numerical");
            return "register";
        }

        User u = userService.saveUser(user);

        if (u != null) {
            // System.out.println("save sucess");
            session.setAttribute("message", "Register successfully");

        } else {
            // System.out.println("error in server");
            session.setAttribute("message", "Something wrong server");
        }
        return "redirect:/register";
    }



}
