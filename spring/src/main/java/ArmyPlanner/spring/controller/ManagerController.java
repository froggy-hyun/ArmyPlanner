package ArmyPlanner.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping("/home")
    public String home() {

        return "manager/managerPage";
    }
}