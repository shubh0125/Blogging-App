package com.techlearners.blogapp.users.dtos;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
// returns  response after user is created
public class UserResponse {


    private Long id;
    private String username;
    private String email;
    private String bio;
    private String image;
}
