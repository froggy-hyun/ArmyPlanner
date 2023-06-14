package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myPlanner")
public class MyPlannerController {

    private final EventService eventService;

    @GetMapping("api/events")
    @ResponseBody
    public List<EventDto> listAllEvents() {
        return eventService.listAllEvents();
    }

    @GetMapping
    public String myPlanner(){
        return "myPlanner/planner";
    }

    @PostMapping(value = "create" )
    @ResponseBody
    public String addEvent(@RequestBody EventDto eventDto, Model model) throws Exception {
        String title = eventDto.getTitle();
//            String description = (String) param.get("description");
        String start = eventDto.getStart();
        String end = eventDto.getEnd();

        Event event = EventDto.builder()
                .title(title)
//                    .description(description)
                .start(start)
                .end(end)
                .build().toEntity();

        eventService.saveEvent(event);

        return "redirect:/";
    }


}
