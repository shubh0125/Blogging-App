package com.techlearners.blogapp.users;


import com.techlearners.blogapp.users.dtos.CreateUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UsersServiceTests {

    @Autowired UserService userService;
    

    @Test
    void can_create_users(){

        var user = userService.createUser(new CreateUserRequest(
                "john",
                "pass123",
                "john@gmai.com"
        ));



        Assertions.assertNotNull(user);
        Assertions.assertEquals("john", user.getUsername());

    }

}
