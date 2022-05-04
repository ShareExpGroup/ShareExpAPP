package com.shareExp.backend.service;

import com.shareExp.backend.model.SuperUser;
import com.shareExp.backend.repository.SuperUserRepository;
import org.springframework.stereotype.Service;

@Service
public class SuperUserService extends UserService<SuperUser> {
    public SuperUserService(SuperUserRepository superUserRepository) {
        super(superUserRepository);
    }
}
