package pl.coderslab.charity.passwordReset.Dto;

import lombok.Data;
import pl.coderslab.charity.validator.PasswordMatches;

@Data
public class PasswordResetDto {

    private String oldPassword;
    private String token;

    private String newPassword;
    private String newMatchingPassword;
}
