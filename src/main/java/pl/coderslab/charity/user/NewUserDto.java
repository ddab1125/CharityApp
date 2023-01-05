package pl.coderslab.charity.user;

import lombok.Data;
import pl.coderslab.charity.validator.PasswordMatches;
import pl.coderslab.charity.validator.UniqueEmail;

@Data
@PasswordMatches
public class NewUserDto {


    private String password;
    private String matchingPassword;

    @UniqueEmail
    private String email;
}
