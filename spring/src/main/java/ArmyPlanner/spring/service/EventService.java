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
            EventDto eventDto = new EventDto();

            eventDto.setId(list.get(i).getId());
            eventDto.setEventType(list.get(i).getEventType());
            eventDto.setTitle(list.get(i).getTitle());

            eventDto.setFood_name(list.get(i).getFood_name());
            eventDto.setKcal(list.get(i).getKcal());
            eventDto.setCarbohydrate(list.get(i).getCarbohydrate());
            eventDto.setProtein(list.get(i).getProtein());
            eventDto.setFat(list.get(i).getFat());
            eventDto.setSugar(list.get(i).getSugar());
            eventDto.setSalt(list.get(i).getSalt());
            eventDto.setCholesterol(list.get(i).getCholesterol());
            eventDto.setSaturatedFattyAcids(list.get(i).getSaturatedFattyAcids());
            eventDto.setTransFattyAcids(list.get(i).getTransFattyAcids());

            eventDto.setShopping_name(list.get(i).getShopping_name());
            eventDto.setTotal_price(list.get(i).getTotal_price());

            eventDto.setPlaceName(list.get(i).getPlaceName());
            eventDto.setAddress(list.get(i).getAddress());
            eventDto.setX(list.get(i).getX());
            eventDto.setY(list.get(i).getY());

            eventDto.setStart(list.get(i).getStart().toString());
            eventDto.setEnd(list.get(i).getEnd().toString());
            eventDto.setAllDay(list.get(i).isAllDay());
            eventsDto.add(eventDto);
        }

        return eventsDto;
    }

    public List<EventDto> findYesterdayDiets(Member member, String yesterdayDate){
        List<Event> list = eventRepository.findAllByMemberAndEventTypeAndStartDate(member, "diet", yesterdayDate);

        List<EventDto> yesterdayDietDto = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            EventDto dietDto = new EventDto();

            dietDto.setId(list.get(i).getId());
            dietDto.setTitle(list.get(i).getTitle());
            dietDto.setFood_name(list.get(i).getFood_name().toString());
            dietDto.setKcal(list.get(i).getKcal().toString());
            dietDto.setFood_name(list.get(i).getFood_name().toString());
            dietDto.setCarbohydrate(list.get(i).getCarbohydrate().toString());
            dietDto.setProtein(list.get(i).getProtein().toString());
            dietDto.setFat(list.get(i).getFat().toString());
            dietDto.setSugar(list.get(i).getSugar().toString());
            dietDto.setSalt(list.get(i).getSalt().toString());
            dietDto.setCholesterol(list.get(i).getCholesterol().toString());
            dietDto.setSaturatedFattyAcids(list.get(i).getSaturatedFattyAcids().toString());
            dietDto.setTransFattyAcids(list.get(i).getTransFattyAcids().toString());

            yesterdayDietDto.add(dietDto);
        }

        return yesterdayDietDto;
    }

    public Event saveEvent(Event event) {

        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }


}