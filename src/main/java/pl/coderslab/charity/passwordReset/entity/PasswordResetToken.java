package pl.coderslab.charity.passwordReset.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.coderslab.charity.user.entity.User;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@Getter
public class PasswordResetToken {

    private static final long EXPIRATION = (60 * 24) * 60;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private Date expiryDate;


    public PasswordResetToken(String token, User user) {
        this.token = token;
        this.user = user;
        this.expiryDate = Date.from(Instant.now().plusSeconds(EXPIRATION));
    }

}
