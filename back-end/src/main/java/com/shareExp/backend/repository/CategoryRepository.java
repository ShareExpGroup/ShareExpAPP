package com.shareExp.backend.repository;

import com.shareExp.backend.model.Category;
import com.shareExp.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
