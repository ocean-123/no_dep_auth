package com.example.proj_auth_no_depn.Service;

import com.example.proj_auth_no_depn.Entity.User;
import com.example.proj_auth_no_depn.Repo.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User saveUser(User user) {
        String pp = user.getPassword();
        System.out.println(pp);
        String password = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        user.setRole("ROLE_USER");

        User newUser = userRepo.save(user);

        return newUser;


    }

    @Override
    public void removeSessionMessage() {

        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
        session.removeAttribute("message");

    }
}
