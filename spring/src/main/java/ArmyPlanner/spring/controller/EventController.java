package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "myPlanner/api/events", produces = "application/json")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping
    public List<EventDto> listAllEvents() {
        return eventService.listAllEvents();
    }

}
