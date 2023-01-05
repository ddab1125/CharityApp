package pl.coderslab.charity.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.user.NewUserDto;
import pl.coderslab.charity.user.mapper.UserMapper;
import pl.coderslab.charity.user.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final UserMapper mapper;

    @RequestMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new NewUserDto());
        return "register";
    }

    @PostMapping("/register")
    public String saveUserForm(@ModelAttribute("user") @Valid NewUserDto user,
                               BindingResult result) {
    if (result.hasErrors()) {
        System.out.println(result.getAllErrors());
        return "register";
    }

        userService.saveNewUser(mapper.toUser(user));
        return "index";
    }
}
