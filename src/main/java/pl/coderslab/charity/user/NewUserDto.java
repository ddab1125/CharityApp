package pl.coderslab.charity.user;

import lombok.Data;
import pl.coderslab.charity.validator.PasswordMatches;
import pl.coderslab.charity.validator.UniqueEmail;

import javax.validation.constraints.NotBlank;

@Data
@PasswordMatches
public class NewUserDto {


    @NotBlank
    private String password;
    @NotBlank
    private String matchingPassword;

    @UniqueEmail
    @NotBlank(message = "{invalid.user.email}")
    private String email;
}
