package com.techlearners.blogapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class basicRest {

    @GetMapping("/ss")
    public String Hello(){
        return "hello";
    }
}
