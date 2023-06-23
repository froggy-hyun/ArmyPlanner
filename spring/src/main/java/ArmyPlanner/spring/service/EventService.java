package ArmyPlanner.spring.service;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.domain.Event;
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


    public List<EventDto> listAllEvents(Member member) {
        List<Event> list = eventRepository.findAllByMember(member);

        List<EventDto> eventsDto = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            EventDto eventTextDto = new EventDto();

            eventTextDto.setId(list.get(i).getId());
            eventTextDto.setEventType(list.get(i).getEventType());
            eventTextDto.setTitle(list.get(i).getTitle());

            eventTextDto.setFood_name(list.get(i).getFood_name());
            eventTextDto.setKcal(list.get(i).getKcal());
            eventTextDto.setCarbohydrate(list.get(i).getCarbohydrate());
            eventTextDto.setProtein(list.get(i).getProtein());
            eventTextDto.setFat(list.get(i).getFat());
            eventTextDto.setSugar(list.get(i).getSugar());
            eventTextDto.setSalt(list.get(i).getSalt());
            eventTextDto.setCholesterol(list.get(i).getCholesterol());
            eventTextDto.setSaturatedFattyAcids(list.get(i).getSaturatedFattyAcids());
            eventTextDto.setTransFattyAcids(list.get(i).getTransFattyAcids());

            eventTextDto.setStart(list.get(i).getStart().toString());
            eventTextDto.setEnd(list.get(i).getEnd().toString());
            eventTextDto.setAllDay(list.get(i).isAllDay());
            eventsDto.add(eventTextDto);
        }

        return eventsDto;
    }

    public Event saveEvent(Event event) {

        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}