package com.shareExp.backend.model;

import com.shareExp.backend.enumeration.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class ShareExpClient extends User{
/*
    @OneToMany
    @JoinColumn(name = "id_share")
      private Set<Comment> items;*/


    public ShareExpClient(String first_name, String last_name, Date birth_date,
                          String email, String password
                          ) {
        super(first_name, last_name, birth_date, Role.CLIENT, email, password);

    }

    public ShareExpClient() {}

}
