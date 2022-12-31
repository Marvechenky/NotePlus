package africa.semicolon.noteapplication.services;
import africa.semicolon.noteapplication.data.dtos.requests.UserLoginRequest;
import africa.semicolon.noteapplication.data.dtos.requests.UserRegistrationRequest;
import africa.semicolon.noteapplication.data.dtos.requests.UserUpdateRequest;
import africa.semicolon.noteapplication.data.dtos.responses.Response;
import africa.semicolon.noteapplication.data.dtos.responses.UserLoginResponse;
import africa.semicolon.noteapplication.data.dtos.responses.UserRegistrationResponse;
import africa.semicolon.noteapplication.data.dtos.responses.UserUpdateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    private UserRegistrationRequest firstUserRegistrationRequest;
    private UserRegistrationRequest secondUserRegistrationRequest;
    private UserLoginRequest userLoginRequest;


    @BeforeEach
    void setUp() {
        firstUserRegistrationRequest = new UserRegistrationRequest();
        firstUserRegistrationRequest.setFirstName("Marvis");
        firstUserRegistrationRequest.setLastName("Alimhiantare");
        firstUserRegistrationRequest.setEmail("marvis_a9@gmail.com");
        firstUserRegistrationRequest.setUsername("Marvechenky");
        firstUserRegistrationRequest.setPassword("Chenky909!");

        secondUserRegistrationRequest = new UserRegistrationRequest();
        secondUserRegistrationRequest.setFirstName("Jude");
        secondUserRegistrationRequest.setLastName("Agege");
        secondUserRegistrationRequest.setEmail("jude_agege@yahoo.com");
        secondUserRegistrationRequest.setUsername("Omo_Agege");
        secondUserRegistrationRequest.setPassword("Agege$10");

    }

    @Test
    void registerToUseNote_Test(){
        UserRegistrationResponse userRegistrationResponse
                = userService.register(firstUserRegistrationRequest);
       UserRegistrationResponse anotherUserRegistrationResponse
        = userService.register(secondUserRegistrationRequest);
        System.out.println(userRegistrationResponse);
        System.out.println(anotherUserRegistrationResponse);
        assertNotNull(userRegistrationResponse);
        assertNotNull(anotherUserRegistrationResponse);
        assertEquals("user registered successfully", userRegistrationResponse.getMessage());
        assertEquals("user registered successfully", anotherUserRegistrationResponse.getMessage());
    }

    @Test
    void registeredUserCanLoginWithValidCredentialsToUseNote_Test(){
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("Marvechenky");
        userLoginRequest.setPassword("Chenky909!");
        UserLoginResponse userLoginResponse
               = userService.login(userLoginRequest);
        System.out.println(userLoginResponse);
        assertNotNull(userLoginResponse);
        assertEquals("Welcome to NotePlus", userLoginResponse.getMessage());

    }


   @Test
   void userDetailsCanBeUpdated_Test(){
       UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
       userUpdateRequest.setId("63aed383aae6275113dc2f4d");
       userUpdateRequest.setUsername("Omo_Ikeja");
       userUpdateRequest.setFirstName("Joel");
       userUpdateRequest.setLastName("Ikeja");
       userUpdateRequest.setPassword("Ikeja#10");
       UserUpdateResponse userUpdateResponse
               = userService.update(userUpdateRequest);
       System.out.println(userUpdateResponse);
       assertNotNull(userUpdateResponse);
       assertEquals("user details updated successfully", userUpdateResponse.getMessage());

   }

    @Test
    void registeredUserCanBeDeleted_Test(){
        Response response = userService.deleteUser("63af394bb7530616d9ee5f90");
        assertEquals("User deleted", response.getMessage());

    }

    @Test
    void allRegisteredUserCanBeDeleted_Test(){
        Response response = userService.deleteAllUsers();
        assertEquals("All users deleted", response.getMessage());
    }
}