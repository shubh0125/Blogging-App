package com.techlearners.blogapp.users;

import com.techlearners.blogapp.common.dtos.ErrorResponse;
import com.techlearners.blogapp.users.dtos.CreateUserRequest;
import com.techlearners.blogapp.users.dtos.UserResponse;
import com.techlearners.blogapp.users.dtos.LoginUserRequest;
import com.techlearners.blogapp.users.dtos.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerTypePredicate;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class  UsersController {

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
            UsersService.UserNotFoundException.class,
            UsersService.InvalidCredentialException.class
    })
    ResponseEntity<ErrorResponse> handleUserExceptions(Exception ex){

        String message;
        HttpStatus status;

        if(ex instanceof UsersService.UserNotFoundException){
            message = ex.getMessage();
            status = HttpStatus.NOT_FOUND;
        }
        else if(ex instanceof UsersService.InvalidCredentialException) {
            message = ex.getMessage();
            status = HttpStatus.UNAUTHORIZED;
        }
        else {
            message = "Something Went Wrong";
            status = HttpStatus.INTERNAL_SERVER_ERROR;

        }
        ErrorResponse response  = ErrorResponse.builder()
                .message(message)
                .build();

        return ResponseEntity.status(status).body(response);
    }


}
