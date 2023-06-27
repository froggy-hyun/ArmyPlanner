package ArmyPlanner.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {

    @GetMapping("searchView")
    public String searchView(){
        return "map/searchView";
    }

    @GetMapping("armyFacilityView")
    public String armyFacilityView(){
        return "map/map_armyFacilityView";
    }

    @GetMapping("armyHospitalView")
    public String armyHospitalView(){
        return "map/map_armyHospitalView";
    }

    @GetMapping("armyTmoView")
    public String armyTmoView(){
        return "map/map_armyTmoView";
    }
}
