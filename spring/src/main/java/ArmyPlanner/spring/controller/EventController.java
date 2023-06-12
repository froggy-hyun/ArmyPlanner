package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "myPlanner/api/events", produces = "application/json")
public class EventController {

    private final EventService eventService;

    @GetMapping
    public List<EventDto> listAllEvents() {
        return eventService.listAllEvents();
    }

    @PostMapping
    @ResponseBody
    public String addEvent(@RequestBody Map<String, Object> param) throws Exception {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA);

        for (int i = 0; i < param.size(); i++) {

            String title = (String) param.get("title");
            String description = (String) param.get("description");
            String startDateString = (String) param.get("start");
            String endDateString = (String) param.get("end");

            LocalDateTime startDate = LocalDateTime.parse(startDateString, dateTimeFormatter);
            LocalDateTime endDate = LocalDateTime.parse(endDateString, dateTimeFormatter);

            Event event = Event.builder()
                    .title(title)
//                    .description(description)
                    .start(startDate)
                    .end(endDate)
                    .build();

            eventService.saveEvent(event);

        }
        return "redirect:/myPlanner";
    }


}
