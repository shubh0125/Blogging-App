package com.techlearners.blogapp.comments;

import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles/{article-slug}/comments")
public class CommentsController {


    @GetMapping("")
    String getUsers(){
        return "Comments";
    }
}
