package africa.semicolon.noteapplication.services;

import africa.semicolon.noteapplication.data.dtos.requests.UserLoginRequest;
import africa.semicolon.noteapplication.data.dtos.requests.UserRegistrationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.UserUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.Response;
import africa.semicolon.noteapplication.data.dtos.responses.UserLoginResponse;
import africa.semicolon.noteapplication.data.dtos.responses.UserRegistrationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.UserUpdateResponse;

public interface UserService {

    UserRegistrationResponse register(UserRegistrationRequest userRegistrationRequest);

    UserLoginResponse login(UserLoginRequest userLoginRequest);

    UserUpdateResponse update(UserUpdateRequest userUpdateRequest);

    Response deleteUser(String id);

    Response deleteAllUsers();


}
