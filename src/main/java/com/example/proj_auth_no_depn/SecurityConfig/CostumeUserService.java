package com.example.proj_auth_no_depn.SecurityConfig;


import com.example.proj_auth_no_depn.Entity.User;
import com.example.proj_auth_no_depn.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CostumeUserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        System.out.println(user);
        if (user==null)
        {
            throw new UsernameNotFoundException("user not fount");
        }
        else {
return  new CostumeUser(user);
        }



    }
}
