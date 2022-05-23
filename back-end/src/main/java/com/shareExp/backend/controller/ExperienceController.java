package com.shareExp.backend.controller;

import com.shareExp.backend.DTO.ExperienceDto;
import com.shareExp.backend.model.Experience;
import com.shareExp.backend.service.ExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/exp")
public class ExperienceController {
    private ExperienceService experienceService;



    @PostMapping(path = "/add",
            consumes="multipart/form-data",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Experience>
    addOffer(@ModelAttribute ExperienceDto experienceDto )
            throws IOException, NoSuchAlgorithmException {
        return new ResponseEntity<>(
                experienceService.AddExperience(experienceDto),
                HttpStatus.CREATED
        );
    }}