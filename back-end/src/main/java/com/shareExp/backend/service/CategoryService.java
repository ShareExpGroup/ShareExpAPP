package com.shareExp.backend.service;

import com.shareExp.backend.DTO.CatDTO;
import com.shareExp.backend.DTO.CategoryDto;
import com.shareExp.backend.DTO.ExperienceDto;
import com.shareExp.backend.model.Category;
import com.shareExp.backend.model.Experience;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.repository.CategoryRepository;
import com.shareExp.backend.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {



    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private ImageService imageService;
    @PersistenceContext
    private EntityManager entityManager;


    public Category AddCategory(CategoryDto experience)
            throws IOException, NoSuchAlgorithmException
    {

        Category category =
                new Category(experience.getName());
        String img =  imageService.uploadCategoryImage(category,experience.getImage());
        category.setImage(img);
        categoryRepository.save(category);
        return category;


    }
    public List<CatDTO> getAllOffers() {
        List<Category> categories =  categoryRepository.findAll();
        return categories.stream().map(CatDTO::new).collect(Collectors.toList());
    }

    public Category findByName(String name) {

        return categoryRepository.findByName(name).orElse(null);
    }
}
