package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class RegistryController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/registry")
    public String registryForm(Model model) {
        model.addAttribute("memberRegistryDto", new MemberRegistryDto());
        return "user/register";
    }

    @PostMapping("/registry") //@valid : 객체의 유효성 검증
    public String registry(@ModelAttribute @Valid MemberRegistryDto memberRegistryDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/register";
        }
        try {
            Member member = Member.createMember(memberRegistryDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "user/register";
        }

        return "redirect:/login";
    }

}
