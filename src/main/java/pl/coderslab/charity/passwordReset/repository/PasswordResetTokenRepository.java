package pl.coderslab.charity.passwordReset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.passwordReset.entity.PasswordResetToken;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;

@Repository
@Transactional
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {


     PasswordResetToken findPasswordResetTokenByToken(String token);

     void deletePasswordResetTokenByToken(String token);

     @Modifying
     @Query("DELETE FROM PasswordResetToken t WHERE t.expiryDate < :date")
     void deleteExpiredPasswordResetToken(LocalDateTime date);
}
