package pl.coderslab.charity.user.mapper;


import org.springframework.stereotype.Component;
import pl.coderslab.charity.user.NewUserDto;
import pl.coderslab.charity.user.entity.User;


@Component
public class UserMapper {


    public User toUser(NewUserDto newUserDto) {
        User user = new User();
        user.setEmail(newUserDto.getEmail());
        user.setPassword(newUserDto.getPassword());

        return user;
    }
}
