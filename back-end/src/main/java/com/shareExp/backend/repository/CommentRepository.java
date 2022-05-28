 package com.shareExp.backend.repository;


import com.shareExp.backend.model.Comment;
import com.shareExp.backend.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findAllById(Long id);

    Optional<List<Comment>> findCommentsByExperience(Experience experience);


}