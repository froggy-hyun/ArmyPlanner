package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.domain.UserDto;
import ArmyPlanner.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserIndexController {

    private UserService userService;

    @GetMapping("/auth/join")
    public String join() {
        return "/user/register";
    }

    @PostMapping("/auth/joinProc")
    public String joinProc(UserDto userDto) {
        userService.join(userDto);

        return "redirect:/auth/login";
    }

    @GetMapping("/auth/login")
    public String login() {
        return "/user/login";
    }


}
