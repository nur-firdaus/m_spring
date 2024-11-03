package com.mspring.controller;

import com.mspring.model.Comment;
import com.mspring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> comments = commentService.fetchComments();

        // Return ResponseEntity with OK status and the list of comments
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
