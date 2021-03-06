package com.shareExp.backend.controller;

import com.shareExp.backend.DTO.ExpRequestDto;
import com.shareExp.backend.DTO.ExperienceDto;
import com.shareExp.backend.model.Experience;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.service.ExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/api/exp")
public class ExperienceController {
    private ExperienceService experienceService;



    @PostMapping(path = "/add",
            consumes="multipart/form-data",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Experience>
    addExp(@ModelAttribute ExperienceDto experienceDto )
            throws IOException, NoSuchAlgorithmException {
        return new ResponseEntity<>(
                experienceService.AddExperience(experienceDto),
                HttpStatus.CREATED
        );
    }/*
    @GetMapping(path = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExperienceDto>> getAllExperiences(){
        return new ResponseEntity<>(
                experienceService.getAllExperiences(),
                HttpStatus.OK
        );
    }*/
    @DeleteMapping(path = "/delete/{id}")
    public void deleteExperience(@PathVariable long id){
        experienceService.deleteExperience(id);
    }
    /*
    //to be tested
    /*
    @PostMapping(path = "/search/byClient",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExperienceDto>> getExpByShareClient(@Valid @RequestBody ShareExpClient shareExpClient){
        List<ExperienceDto> offers = experienceService.getExpByShareClient(shareExpClient);
        return new ResponseEntity<>(
                offers,
                HttpStatus.OK
        );
    }*/

    @GetMapping(path = "/Popular")
    public ResponseEntity<List<ExpRequestDto>> getPopularExperiences(){
        List<ExpRequestDto> experiences = experienceService.getPopularExperiences(5);
        return new ResponseEntity<>(
                experiences,
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/category/{id}")
    public ResponseEntity<List<ExpRequestDto>> getExperiencesByCategory(@PathVariable long id){
        List<ExpRequestDto> experiences = experienceService.getExpByCategory(id);
        return new ResponseEntity<>(
                experiences,
                HttpStatus.OK
        );
    }
/*
    @GetMapping(path = "/Popular")
    public ResponseEntity<List<Experience>> getPopularExperiences(){
        List<Experience> experiences = experienceService.getPopularExperiences(5);
        return new ResponseEntity<>(
                experiences,
                HttpStatus.OK
        );
    }*/

    @GetMapping (path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExpRequestDto> getExpById(@PathVariable long id){
        return new ResponseEntity<>(
                experienceService.getExpById(id),
                HttpStatus.OK
        );
    }

}