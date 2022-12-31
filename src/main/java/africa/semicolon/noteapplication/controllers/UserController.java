package africa.semicolon.noteapplication.controllers;

import africa.semicolon.noteapplication.data.dtos.requests.UserLoginRequest;
import africa.semicolon.noteapplication.data.dtos.requests.UserRegistrationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.UserUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.Response;
import africa.semicolon.noteapplication.data.dtos.responses.UserLoginResponse;
import africa.semicolon.noteapplication.data.dtos.responses.UserRegistrationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.UserUpdateResponse;
import africa.semicolon.noteapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public UserRegistrationResponse register(@RequestBody UserRegistrationRequest userRegistrationRequest){
        return userService.register(userRegistrationRequest);
    }


    @PostMapping(value = "/login")
    public UserLoginResponse login (@RequestBody UserLoginRequest userLoginRequest){
        return userService.login(userLoginRequest);
    }

    @PutMapping(value = "/update")
    public UserUpdateResponse update(@RequestBody UserUpdateRequest userUpdateRequest){
        return userService.update(userUpdateRequest);
    }

    @DeleteMapping(path = "/user/{id}")
    public Response deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }

    @DeleteMapping(path = "/users")
    public Response deleteAllUsers(){
        return userService.deleteAllUsers();
    }
}
