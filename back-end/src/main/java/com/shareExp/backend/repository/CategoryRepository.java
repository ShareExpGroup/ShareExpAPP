package com.shareExp.backend.repository;

import com.shareExp.backend.model.Category;
import com.shareExp.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
