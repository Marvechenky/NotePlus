package africa.semicolon.noteapplication.data.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class UserRegistrationRequest {

    @NotNull(message = "first name is mandatory")
    private String firstName;

    @NotNull(message = "last name is mandatory")
    private String lastName;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)

    @NotNull
    private String email;

    @NotNull(message = "username is mandatory")
    @Size(min = 8, max = 20)
    private String username;

    @NotNull(message = "password is mandatory")
    @Size(min = 8, max = 20)
    private String password;


}
