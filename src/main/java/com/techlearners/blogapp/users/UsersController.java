package com.techlearners.blogapp.users;

import com.techlearners.blogapp.users.dtos.CreateUserRequest;
import com.techlearners.blogapp.users.dtos.UserResponse;
import com.techlearners.blogapp.users.dtos.LoginUserRequest;
import com.techlearners.blogapp.users.dtos.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
    private final ModelMapper modelMapper;

    public UsersController(UsersService usersService, ModelMapper modelMapper) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    ResponseEntity<UserResponse> signupUser(@RequestBody CreateUserRequest request){
        UserEntity savedUser = usersService.createUser(request);
        URI savedUserUri = URI.create("/users/" + savedUser.getId());
        return ResponseEntity.created(savedUserUri)
                .body(modelMapper.map(savedUser, UserResponse.class));
    }

    @PostMapping("/login")
    ResponseEntity<UserResponse> loginUser(@RequestBody LoginUserRequest request){
        UserEntity savedUser = usersService.loginUser(request.getUsername(), request.getPassword());
        URI savedUserUri = URI.create("/users/"+ savedUser.getId());

        return ResponseEntity.ok(modelMapper.map(savedUser, UserResponse.class));
    }

    @ExceptionHandler({
            UsersService.UserNotFoundException.class
    })
    ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex){
        return ResponseEntity.notFound().build();
    }


}
