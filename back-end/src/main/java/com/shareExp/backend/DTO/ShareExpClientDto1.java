package com.shareExp.backend.DTO;

import com.shareExp.backend.model.Experience;
import com.shareExp.backend.model.ShareExpClient;
import lombok.Data;

import java.io.Serializable;

@Data
public class ShareExpClientDto1 implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String email;

    public ShareExpClientDto1(ShareExpClient shareExpClient){
        this.firstName=shareExpClient.getFirstName();
        this.lastName=shareExpClient.getLastName();
        this.email=shareExpClient.getEmail();
    }
}

