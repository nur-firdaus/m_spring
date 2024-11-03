package com.mspring.service;

import com.mspring.model.Comment;
import com.mspring.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private RestTemplate restTemplate;
    private static final String API_URL = "https://jsonplaceholder.typicode.com/comments";

    public List<Comment> fetchComments() {

        Comment[] commentsArray = restTemplate.getForObject(API_URL, Comment[].class);

        return Arrays.asList(commentsArray);
    }
}
