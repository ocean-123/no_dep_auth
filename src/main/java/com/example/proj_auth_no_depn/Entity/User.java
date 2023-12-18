package com.example.proj_auth_no_depn.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.intellij.lang.annotations.Pattern;
import org.springframework.data.annotation.Id;


@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Getter
//@Setter

public class User {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String first_name;
    private  String last_name;


//    @Pattern( "^[a-z0-9]+@[a-z0-9]+\\.(gmail|yahoo|outlook)\\.(com|in|edu)$")
    private  String email;



    private  String phone;

    private  String password;

    private  String role;

    private  boolean verification;

    public boolean isVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
