package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;


    public List<EventDto> listAllEvents() {
        List<Event> list = eventRepository.findAll();

        List<EventDto> eventsDto = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            EventDto eventDto = new EventDto();

            eventDto.setId(list.get(i).getId());
            eventDto.setTitle(list.get(i).getTitle());
            eventDto.setStart(list.get(i).getStart().toString());
            eventDto.setEnd(list.get(i).getEnd().toString());
            eventsDto.add(eventDto);
        }

        return eventsDto;
    }

}