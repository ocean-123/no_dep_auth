package com.example.proj_auth_no_depn.Controller;


import com.example.proj_auth_no_depn.Entity.User;
import com.example.proj_auth_no_depn.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class AdminController {

    @Autowired
    private UserRepo userRepo;

    @ModelAttribute
    public void commonUser(Principal p, Model m) {
        if (p != null) {
            String email = p.getName();
            User user = userRepo.findByEmail(email);
            m.addAttribute("user", user);
        }

    }


    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("user");

        return "user/profile";
    }
}