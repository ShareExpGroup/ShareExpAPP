package com.shareExp.backend.model;

import com.shareExp.backend.enumeration.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ShareExpClient extends User{




    public ShareExpClient(String first_name, String last_name, Date birth_date,
                          String email, String password
                          ) {
        super(first_name, last_name, birth_date, Role.CLIENT, email, password);

    }

    public ShareExpClient() {}

}
