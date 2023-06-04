package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.domain.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal SecurityUser principal, Model model) {
        if (principal != null) {
            model.addAttribute("principal", principal.getMember());
            model.addAttribute("role", principal.getMember().getRole().getDescription());
        }
        return "manager/managerPage";
    }
}