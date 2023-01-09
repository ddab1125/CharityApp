package pl.coderslab.charity.passwordReset.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.passwordReset.entity.PasswordResetToken;
import pl.coderslab.charity.passwordReset.repository.PasswordResetTokenRepository;

import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    public void saveToken(PasswordResetToken token) {
        passwordResetTokenRepository.save(token);
    }

    public PasswordResetToken findByToken(String token){
        return passwordResetTokenRepository.findPasswordResetTokenByToken(token);
    }

    public void deleteToken(String token){
        passwordResetTokenRepository.deletePasswordResetTokenByToken(token);
    }
    public String validatePasswordResetToken(String token){
        final PasswordResetToken passToken = passwordResetTokenRepository.findPasswordResetTokenByToken(token);
        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                : null;
    }

    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(PasswordResetToken passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }


}
