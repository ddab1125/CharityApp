package pl.coderslab.charity.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.passwordReset.Dto.PasswordResetDto;
import pl.coderslab.charity.passwordReset.service.PasswordResetTokenService;
import pl.coderslab.charity.user.entity.User;
import pl.coderslab.charity.user.service.UserService;
import pl.coderslab.charity.web.email.EmailDetails;
import pl.coderslab.charity.web.email.EmailService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ForgotPasswordController {

    private final EmailService emailService;
    private final UserService userService;

    private final PasswordResetTokenService passwordResetTokenService;

    @GetMapping("/reset")
    public String forgotPassword() {
        return "passwordReset/forgotpassword";
    }

    @PostMapping("/reset")
    public String resetPassword(HttpServletRequest request, @RequestParam("email") String email) {
        User user = userService.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);

        String s = emailService.sendMail(emailService.constructResetTokenEmail(request.getServletPath(), token, user));


        return "/passwordReset/mailsent";
    }

    @GetMapping("/reset/passwordreset")
    public String resetPasswordForm(@RequestParam String token, Model model) {
        model.addAttribute("passwordReset", new PasswordResetDto());
        String result = passwordResetTokenService.validatePasswordResetToken(token);
        if (result != null) {
            return "passwordReset/failedtoreset";
        } else {
            model.addAttribute("token", token);
            return "passwordReset/passwordreset";
        }
    }

    @PostMapping("/reset/passwordreset")
    public String changePassword(@ModelAttribute("passwordReset") @Valid PasswordResetDto passwordResetDto) {
       String result = passwordResetTokenService.validatePasswordResetToken(passwordResetDto.getToken());

//       if (result != null) {
//           return "passwordReset/passwordreset" + "?token=" + passwordResetDto.getToken();
//       }

       Optional user = userService.getUserByToken(passwordResetDto.getToken());
       if (user.isPresent()) {
           userService.changePassword((User) user.get(), passwordResetDto.getNewPassword());
            passwordResetTokenService.deleteToken(passwordResetDto.getToken());
           return "passwordReset/succespasswordreset";
       } else {
           return "passwordReset/passwordreset";
       }

    }
}
