package pl.coderslab.charity.passwordReset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.passwordReset.entity.PasswordResetToken;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {


     PasswordResetToken findPasswordResetTokenByToken(String token);

     void deletePasswordResetTokenByToken(String token);
}
