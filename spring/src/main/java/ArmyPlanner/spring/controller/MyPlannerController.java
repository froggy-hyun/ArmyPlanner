package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.repository.MemberRepository;
import ArmyPlanner.spring.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myPlanner")
public class MyPlannerController {

    private final EventService eventService;
    private final MemberRepository memberRepository;

    @GetMapping("api/events")
    @ResponseBody
    public List<EventDto> listAllEvents(Principal principal) {
        String username = principal.getName();
        Member member = memberRepository.findByEmail(username);
        return eventService.listAllEvents(member);
    }

    @GetMapping
    public String myPlanner(){
        return "myPlanner/planner";
    }

    @PostMapping(value = "create")
    @ResponseBody
    public void addEvent(@RequestBody EventDto eventDto, Principal principal) throws Exception {
        String title = eventDto.getTitle();
//            String description = (String) param.get("description");
        String start = eventDto.getStart();
        String end = eventDto.getEnd();
        boolean allDay = eventDto.isAllDay();
        String username = principal.getName();
        Member member = memberRepository.findByEmail(username);

        Event event = EventDto.builder()
                .title(title)
//                    .description(description)
                .start(start)
                .end(end)
                .allDay(allDay)
                .member(member)
                .build().toEntity();

        eventService.saveEvent(event);
    }

    @DeleteMapping(value = "delete")
    @ResponseBody
    public void deleteEvent(@RequestBody EventDto eventDto, Principal principal) throws Exception {
        Long id = eventDto.getId();
        eventService.deleteEvent(id);
    }

}
