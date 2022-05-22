package com.shareExp.backend.controller;


import com.shareExp.backend.model.Comment;
import com.shareExp.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;


    @GetMapping("/comments")
    @ResponseBody
    public List<Comment> getAllComments(HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        return commentRepository.findAll();
    }


    @PostMapping("/comments")
    @ResponseBody
    public Comment createComment(Comment comment, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return commentRepository.save(comment);
    }





}