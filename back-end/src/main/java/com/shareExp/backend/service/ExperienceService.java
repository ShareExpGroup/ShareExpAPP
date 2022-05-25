package com.shareExp.backend.service;

import com.shareExp.backend.DTO.ExperienceDto;
import com.shareExp.backend.model.Experience;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import static com.shareExp.backend.enumeration.Role.CLIENT;

@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private  ClientService clientService;

    @Autowired
    private ImageService imageService;
    @PersistenceContext
    private EntityManager entityManager;
    public ExperienceService(ExperienceRepository experienceRepository, ClientService clientService, ImageService imageService, EntityManager entityManager) {
        this.experienceRepository = experienceRepository;
        this.clientService = clientService;
        this.imageService = imageService;
        this.entityManager = entityManager;
    }

    public ExperienceService() {
    }

    public  Experience AddExperience(ExperienceDto experience)
            throws IOException, NoSuchAlgorithmException
    {
        String email = "admin@gmail.com";
        //(String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


Experience exp =
        new Experience(clientService.findByEmail(email),experience.getTitle(), 5,experience.getDescription());
        String img =  imageService.uploadExpImage(exp,experience.getImage());
        exp.setImage(img);
        exp.setShareExpClient(clientService.findByEmail(email));
        experienceRepository.save(exp);
        return  exp;

}
}