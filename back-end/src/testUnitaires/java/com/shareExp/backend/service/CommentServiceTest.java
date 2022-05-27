package com.shareExp.backend.service;

import com.shareExp.backend.DTO.CommentDto;
import com.shareExp.backend.DTO.ShareExpClientDto;
import com.shareExp.backend.model.Comment;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.model.User;
import com.shareExp.backend.repository.ClientRepository;
import com.shareExp.backend.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

     @Mock
     ClientService clientService;
     @Mock
    ClientRepository clientRepository;
    @Mock
    CommentRepository commentRepository;

    @Test
    @DisplayName("should add comment")
    void ShouldAddComment() {

            ClientService clientService = new ClientService(clientRepository);

            CommentService commentService=new CommentService(commentRepository,clientService);
            ShareExpClient shareExpClient =  new ShareExpClient("jihad","dourhnou",new Date(2000, Calendar.NOVEMBER,2),"jihad@gmail.com","test");
            //Comment comment = new Comment(shareExpClient ,"contentOfComment");
            ShareExpClientDto shareExpClientDto = new ShareExpClientDto(1,"jihad","dourhnou");
            CommentDto commentDto = new CommentDto("contentOfComment",shareExpClientDto);
            Comment comment=new Comment(shareExpClient,
                commentDto.getContent());
            Mockito.when(commentRepository.save(comment))
                    .thenReturn(comment);
            Comment actualCommentSaved= commentService.AddComment(commentDto);
            org.assertj.core.api.Assertions.assertThat(commentDto.getContent()).isEqualTo(actualCommentSaved.getContent());


        }
    }
