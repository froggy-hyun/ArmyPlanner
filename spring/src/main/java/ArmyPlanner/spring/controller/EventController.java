package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/myPlanner/api/events", produces = "application/json")
public class EventController {

    private final EventService eventService;

    @GetMapping
    public List<EventDto> listAllEvents() {
        return eventService.listAllEvents();
    }

    @PostMapping
    @ResponseBody
    public String addEvent(@RequestBody EventDto eventDto) throws Exception {
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
