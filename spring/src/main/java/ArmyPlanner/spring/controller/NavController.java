package ArmyPlanner.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class NavController {

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/myPlanner")
    public String myPlanner(){
        return "myPlanner/planner";
    }
}