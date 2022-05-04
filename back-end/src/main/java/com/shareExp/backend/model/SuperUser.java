package com.shareExp.backend.model;

import com.shareExp.backend.enumeration.Role;
import com.shareExp.backend.enumeration.SuperUserAuthority;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class SuperUser extends User{

    @ElementCollection(targetClass = SuperUserAuthority.class, fetch = FetchType.EAGER)
    @Column(name = "authorities", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<SuperUserAuthority> authorities;

    public SuperUser(String first_name, String last_name, Date birth_date,
                     String email, String password,
                     List<SuperUserAuthority> authorities) {
        super(first_name, last_name, birth_date, Role.SUPERUSER, email, password);
        this.authorities = authorities;
    }

    public SuperUser() {}

    public List<SuperUserAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<SuperUserAuthority> authorities) {
        this.authorities = authorities;
    }
}
