package pl.coderslab.charity.web.email;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.user.entity.User;

@Service

public class EmailService {


    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;

    public String sendSimpleMail(EmailDetails details, SimpleMailMessage mailMessage) {
        try {
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            javaMailSender.send(mailMessage);
            return "Succes";
        } catch (Exception e) {
            return "Error";
        }
    }

    public String sendMail(SimpleMailMessage mailMessage) {
        try {
            javaMailSender.send(mailMessage);
            return "succes";
        } catch (Exception e) {
            return "error";
        }
    }


    public SimpleMailMessage constructResetTokenEmail(String contextPath, String token, User user) {
        //Jak zrobic to bardziej elegancko
        String url = "http://localhost:8080" + contextPath + "/passwordreset?token=" + token;
        String message = "Resetowanie hasła";
        return constructEmail("Reset Hasła", message + " \r\n" + url, user);
    }

    public SimpleMailMessage constructEmail(String subject, String body,
                                            User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        return email;
    }
}
