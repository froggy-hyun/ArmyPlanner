package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.Event_textDto;
import ArmyPlanner.spring.domain.Event_text;
import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.repository.MemberRepository;
import ArmyPlanner.spring.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    public List<Event_textDto> listAllEvents(Principal principal) {
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
    public void addEvent(@RequestBody Event_textDto eventTextDto, Principal principal) throws Exception {
        String title = eventTextDto.getTitle();
//            String description = (String) param.get("description");
        String start = eventTextDto.getStart();
        String end = eventTextDto.getEnd();
        boolean allDay = eventTextDto.isAllDay();
        String username = principal.getName();
        Member member = memberRepository.findByEmail(username);

        Event_text eventText = Event_textDto.builder()
                .title(title)
//                    .description(description)
                .start(start)
                .end(end)
                .allDay(allDay)
                .member(member)
                .build().toEntity();

        eventService.saveEvent(eventText);
    }

    @DeleteMapping(value = "delete")
    @ResponseBody
    public void deleteEvent(@RequestBody Event_textDto eventTextDto, Principal principal) throws Exception {
        Long id = eventTextDto.getId();
        eventService.deleteEvent(id);
    }

}
