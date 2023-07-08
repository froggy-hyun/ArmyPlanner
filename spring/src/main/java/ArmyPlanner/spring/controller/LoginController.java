package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.service.MemberService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(@RequestParam(value = "status", required = false) String status, Model model) {
        if(status != null && !status.isEmpty()) {
            if(status.equals("success")) {
                model.addAttribute("SuccessMsg", "회원가입 완료!");
            }
        }

        return "user/login";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
        return "user/login?";
    }
}
