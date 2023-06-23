package ArmyPlanner.spring.service;

import ArmyPlanner.spring.Dto.Event_textDto;
import ArmyPlanner.spring.domain.Event_text;
import ArmyPlanner.spring.domain.Member;
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


    public List<Event_textDto> listAllEvents(Member member) {
        List<Event_text> list = eventRepository.findAllByMember(member);

        List<Event_textDto> eventsDto = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Event_textDto eventTextDto = new Event_textDto();

            eventTextDto.setId(list.get(i).getId());
            eventTextDto.setTitle(list.get(i).getTitle());
            eventTextDto.setStart(list.get(i).getStart().toString());
            eventTextDto.setEnd(list.get(i).getEnd().toString());
            eventTextDto.setAllDay(list.get(i).isAllDay());
            eventsDto.add(eventTextDto);
        }

        return eventsDto;
    }

    public Event_text saveEvent(Event_text eventText) {

        return eventRepository.save(eventText);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}