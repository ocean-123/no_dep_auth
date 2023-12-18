package com.example.proj_auth_no_depn.SecurityConfig;

import com.example.proj_auth_no_depn.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CostumeUser implements UserDetails
{
    private User user;

//    public CostumeUser(org.springframework.security.core.userdetails.User user) {
//    }

    public CostumeUser(User user) {
        super();
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =new SimpleGrantedAuthority(user.getRole());


        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
