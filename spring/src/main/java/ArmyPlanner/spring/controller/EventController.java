package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String addEvent(@RequestParam Map<String, Object> param, HttpServletRequest req, HttpServletResponse res) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String title = (String) param.get("title");
//            String description = (String) param.get("description");
        String startDateString = (String) param.get("start");
        String endDateString = (String) param.get("end");
        LocalDateTime start = LocalDateTime.parse(startDateString, formatter);
        LocalDateTime end = LocalDateTime.parse(endDateString, formatter);


        Event event = EventDto.builder()
                .title(title)
//                    .description(description)
                .start(String.valueOf(start))
                .end(String.valueOf(end))
                .build().toEntity();

        eventService.saveEvent(event);


        return "redirect:/myPlanner";
    }


}
