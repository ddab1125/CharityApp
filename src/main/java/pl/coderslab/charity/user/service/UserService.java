package pl.coderslab.charity.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.passwordReset.entity.PasswordResetToken;
import pl.coderslab.charity.passwordReset.service.PasswordResetTokenService;
import pl.coderslab.charity.role.service.RoleService;
import pl.coderslab.charity.user.entity.User;
import pl.coderslab.charity.user.repository.UserRepository;

import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleService roleService;

    private final PasswordResetTokenService passwordResetTokenService;


    public void saveNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        user.setRoles(Arrays.asList(roleService.findRoleByName("user")));

        userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken resetToken = new PasswordResetToken(token, user);
        passwordResetTokenService.saveToken(resetToken);
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id);
    }
    public Optional<User> getUserByToken(String token) {
        return Optional.ofNullable(passwordResetTokenService.findByToken(token).getUser());
    }

    public void changePassword(User user, String password){
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

}
