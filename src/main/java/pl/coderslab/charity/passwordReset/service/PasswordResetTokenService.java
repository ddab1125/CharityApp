package pl.coderslab.charity.passwordReset.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.passwordReset.entity.PasswordResetToken;
import pl.coderslab.charity.passwordReset.repository.PasswordResetTokenRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

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


    public void deleteExpiredToken() {
        passwordResetTokenRepository.deleteExpiredPasswordResetToken(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
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
        return passToken.getExpiryDate().isBefore(LocalDateTime.from(LocalDateTime.now()));
    }


}
