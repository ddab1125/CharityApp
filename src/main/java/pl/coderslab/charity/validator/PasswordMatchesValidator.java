package pl.coderslab.charity.validator;

import pl.coderslab.charity.user.NewUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, NewUserDto> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(NewUserDto user, ConstraintValidatorContext constraintValidatorContext) {
        if (!user.getPassword().equals(user.getMatchingPassword())) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("{passwordMatches.error.message}")
                    .addPropertyNode("matchingPassword").addConstraintViolation();
            return false;
        }
        return true;
    }
}
