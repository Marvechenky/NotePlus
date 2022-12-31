package africa.semicolon.noteapplication.services;

import africa.semicolon.noteapplication.data.dtos.requests.UserLoginRequest;
import africa.semicolon.noteapplication.data.dtos.requests.UserRegistrationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.UserUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.Response;
import africa.semicolon.noteapplication.data.dtos.responses.UserLoginResponse;
import africa.semicolon.noteapplication.data.dtos.responses.UserRegistrationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.UserUpdateResponse;
import africa.semicolon.noteapplication.data.models.User;
import africa.semicolon.noteapplication.exceptions.*;
import africa.semicolon.noteapplication.repositories.UserRepository;
import africa.semicolon.noteapplication.validators.UserDetailsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserRegistrationResponse register(UserRegistrationRequest userRegistrationRequest) {
        if(!UserDetailsValidator.isValidEmailAddress(userRegistrationRequest.getEmail()))
            throw new UserRegistrationEmailAddressException(String
                    .format("email %s is invalid", userRegistrationRequest.getEmail()));

        if(!UserDetailsValidator.isValidPassword(userRegistrationRequest.getPassword()))
            throw new UserRegistrationPasswordException(String
                    .format("password %s is invalid", userRegistrationRequest.getPassword()));

        if(!UserDetailsValidator.isValidUsername(userRegistrationRequest.getUsername()))
            throw new UserRegistrationUsernameException(String
                    .format("username %s is invalid", userRegistrationRequest.getUsername()));

        User user = new User();
        user.setFirstName(userRegistrationRequest.getFirstName());
        user.setLastName(userRegistrationRequest.getLastName());
        user.setUsername(userRegistrationRequest.getUsername());
        user.setPassword(userRegistrationRequest.getPassword());
        User savedUser = userRepository.save(user);

        UserRegistrationResponse userRegistrationResponse
                = new UserRegistrationResponse();
        userRegistrationResponse.setId(savedUser.getId());
        userRegistrationResponse.setMessage("user registered successfully");
        System.out.println("user info --> "+ user);

        return userRegistrationResponse;

    }

    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        User foundUser = userRepository.findByUsername(userLoginRequest.getUsername())
                        .orElseThrow(()-> new UserAlreadyExistException(("username exist")));

        UserLoginResponse userLoginResponse = new UserLoginResponse();

        if (foundUser.getPassword().equals(userLoginRequest.getPassword())) {
            userLoginResponse.setMessage("Welcome to NotePlus");
            return userLoginResponse;
        }
        userLoginResponse.setMessage("authentication failed");
        return userLoginResponse;
    }

    @Override
    public UserUpdateResponse update(UserUpdateRequest userUpdateRequest) {
        User foundUser = userRepository.findById(userUpdateRequest.getId())
                .orElseThrow(()-> new RuntimeException("Oops!...User not found"));
        foundUser.setUsername(userUpdateRequest.getUsername());
        foundUser.setFirstName(userUpdateRequest.getFirstName());
        foundUser.setLastName(userUpdateRequest.getLastName());
        foundUser.setPassword(userUpdateRequest.getPassword());
        userRepository.save(foundUser);
        UserUpdateResponse userUpdateResponse = new UserUpdateResponse();
        userUpdateResponse.setMessage("user details updated successfully");
        return userUpdateResponse;
    }


    @Override
    public Response deleteUser(String id) {
        userRepository.deleteById(id);
        return new Response("User deleted");
    }

    @Override
    public Response deleteAllUsers() {
        userRepository.deleteAll();
        return new Response("All users deleted");
    }

}
