package com.shareExp.backend.service;

import com.shareExp.backend.DTO.ExpRequestDto;
import com.shareExp.backend.DTO.ExperienceDto;
import com.shareExp.backend.exception.ExperienceNotFoundException;
import com.shareExp.backend.exception.UserIncompleteDataException;
import com.shareExp.backend.model.Experience;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return exp;

    }
    /*
    public List<ExperienceDto> getAllExperiences() {
        List<Experience> experiences = experienceRepository.findAll();
        return experiences.stream().map(ExperienceDto::new).collect(Collectors.toList());
    }
    */
    public void deleteExperience(long id) {
        if (id == 0 || !experienceRepository.existsById(id))
            throw new ExperienceNotFoundException(id);
        experienceRepository.deleteById(id);
    }
    /*
    public List<ExperienceDto> getExpByShareClient(ShareExpClient shareExpClient) {

        if (shareExpClient.getId() != 0) {
            Optional<List<Experience>> offers = experienceRepository.findAllByShareExpClientId(shareExpClient.getId());
            if (offers.isPresent()) {
                return offers.get().stream().map(ExperienceDto::new).collect(Collectors.toList());
            }
            return List.of();
        }
        // this will generate an error -- logical error -- when two coaches have the same full name
        if (shareExpClient.getFirstName() != null && shareExpClient.getLastName() != null) {
            Optional<List<Experience>> offers = experienceRepository.findAllOffersByShareExpClientFirstNameAndShareExpClientLastName(shareExpClient.getFirstName(), shareExpClient.getLastName());
            if (offers.isPresent()) {
                return offers.get().stream().map(ExperienceDto::new).collect(Collectors.toList());
            }
            return List.of();
        }
        throw new UserIncompleteDataException("coach's id or full_name");
    }
        public List<ExperienceDto> getExpByShareClient(){
            return getExpByShareClient(clientService.findCurrentClient());
        }*/

        public List<ExpRequestDto> getPopularExperiences(int min_likes){
            Optional<List<Experience>> experiences = experienceRepository.findByLikesGreaterThanEqual(min_likes);
            return experiences.get().stream().map(ExpRequestDto::new).collect(Collectors.toList());
        }

}