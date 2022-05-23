package com.shareExp.backend.service;

import com.shareExp.backend.DTO.ExperienceDto;
import com.shareExp.backend.model.Experience;
import com.shareExp.backend.repository.ExperienceRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
@Service
public class ExperienceService {
    private ExperienceRepository experienceRepository;
    private  ClientService clientService;
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
        String email =
                (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

Experience exp =
        new Experience(clientService.findByEmail(email),experience.getTitle(), experience.getLike(),experience.getDescription());
        String img =  imageService.uploadExpImage(exp,experience.getImage());

        experienceRepository.save(exp);
        return  exp;

}
}