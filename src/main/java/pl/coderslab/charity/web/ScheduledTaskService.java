package pl.coderslab.charity.web;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.passwordReset.service.PasswordResetTokenService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ScheduledTaskService {

    private final PasswordResetTokenService passwordResetTokenService;
    private static final long INTERVAL = (1000 * 3600) * 24;

    @Scheduled(fixedRate = INTERVAL)
    public void scheduledTask() {
        passwordResetTokenService.deleteExpiredToken();
        System.out.println("--deleting expired tokens--");
    }
}
