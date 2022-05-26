package com.shareExp.backend.controller;


import com.shareExp.backend.DTO.CatDTO;
import com.shareExp.backend.DTO.CategoryDto;
import com.shareExp.backend.DTO.ExperienceDto;
import com.shareExp.backend.model.Category;
import com.shareExp.backend.model.Experience;
import com.shareExp.backend.service.CategoryService;
import com.shareExp.backend.service.ExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/api/categ")
public class CategoryController {

    private CategoryService categoryService;



    @PostMapping(path = "/add",
            consumes="multipart/form-data",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Category>
    addExp(@ModelAttribute CategoryDto categoryDto )
            throws IOException, NoSuchAlgorithmException {
        return new ResponseEntity<>(
                categoryService.AddCategory(categoryDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CatDTO>> getAllCategories(){

        return new ResponseEntity<>(
                categoryService.getAllOffers(),
                HttpStatus.OK
        );
    }
}
