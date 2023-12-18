package com.example.proj_auth_no_depn.Service;

import com.example.proj_auth_no_depn.Entity.User;

public interface UserService {

    public User saveUser(User user);

    public void removeSessionMessage();
}
