package africa.semicolon.noteapplication.data.dtos.requests;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
}
