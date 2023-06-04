package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.domain.Role;
import ArmyPlanner.spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RegistryController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/registry")
    public String registryForm(Model model) {
        model.addAttribute("member", new RegistryRequest());
        return "user/register";
    }

    @PostMapping("/registry")
    public String registry(@ModelAttribute RegistryRequest registryRequest) {
        Member member = Member.builder()
                .username(registryRequest.getUsername())
                .password(passwordEncoder.encode(registryRequest.getPassword()))
                .role(registryRequest.getRole())
                .build();
        memberRepository.save(member);

        return "redirect:/login";
    }

}
