package com.shareExp.backend.service;

import com.shareExp.backend.DTO.CommentDto;
import com.shareExp.backend.model.Comment;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.repository.CommentRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private ClientService clientService;

    public CommentService(CommentRepository commentRepository, ClientService clientService) {
        this.commentRepository = commentRepository;
        this.clientService = clientService;
    }

    public Comment AddComment(CommentDto commentDto){
        //for testing
        //String email = "amina.chaabane34@gmail.com";
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment=new Comment(clientService.findByEmail(email),
                commentDto.getContent());
        commentRepository.save(comment);
     return comment;
    }
}
