package com.mspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comment {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
