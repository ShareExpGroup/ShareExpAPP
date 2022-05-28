package com.shareExp.backend.service;

import com.shareExp.backend.DTO.CommDTO;
import com.shareExp.backend.DTO.CommentDto;
import com.shareExp.backend.model.Comment;
import com.shareExp.backend.model.Experience;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ExperienceService experienceService;
    public CommentService(CommentRepository commentRepository, ClientService clientService, ExperienceService experienceService) {
        this.commentRepository = commentRepository;
        this.clientService = clientService;
        this.experienceService = experienceService;
    }
    public CommentService(CommentRepository commentRepository, ClientService clientService) {
        this.commentRepository = commentRepository;
        this.clientService = clientService;
    }

    public CommentService() {
    }

    public Comment AddComment(CommentDto commentDto){

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment=new Comment(clientService.findByEmail(email),
                commentDto.getContent(),experienceService.getExperienceByTitle(commentDto.getExperience()));
        commentRepository.save(comment);
     return comment;
    }

    public List<CommDTO> getAllCommentByex
            (Long id) {
        Experience exp=  experienceService.getfullExpById(id);

        Optional<List<Comment>> experiences = commentRepository.findCommentsByExperience(exp);
        return experiences.get().stream().map(CommDTO::new).collect(Collectors.toList());
    }
}
