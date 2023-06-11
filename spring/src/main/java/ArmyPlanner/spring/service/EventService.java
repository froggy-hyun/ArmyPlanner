package ArmyPlanner.spring.service;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EventService {

    private final EventRepository eventRepository;


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

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

}