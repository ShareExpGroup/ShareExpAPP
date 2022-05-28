package com.shareExp.backend.controller;


import com.shareExp.backend.DTO.CommentDto;
import com.shareExp.backend.model.Comment;
import com.shareExp.backend.repository.CommentRepository;
import com.shareExp.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
CommentService commentService;
    @Autowired
CommentRepository commentRepository;

    @GetMapping("/comments")
    @ResponseBody
    public List<Comment> getAllComments(HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        return commentRepository.findAll();
    }


    @PostMapping(path="/create",
    consumes="multipart/form-data",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment>
    createComment(@ModelAttribute CommentDto comment) {

       return new ResponseEntity<>(
                       commentService.AddComment(comment),
                HttpStatus.CREATED
        );
    }
/*
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
    }*/




}