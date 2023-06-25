package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.repository.MemberRepository;
import ArmyPlanner.spring.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

    @PostMapping(value = "create_text")
    @ResponseBody
    public void addEvent_text(@RequestBody EventDto eventTextDto, Principal principal) throws Exception {
        String eventType = eventTextDto.getEventType();
        String title = eventTextDto.getTitle();
        String start = eventTextDto.getStart();
        String end = eventTextDto.getEnd();
        boolean allDay = eventTextDto.isAllDay();
        String username = principal.getName();
        Member member = memberRepository.findByEmail(username);


        Event eventText = EventDto.builder()
                .eventType(eventType)
                .title(title)
                .start(start)
                .end(end)
                .allDay(allDay)
                .member(member)
                .build().toEntity_text();

        eventService.saveEvent(eventText);
    }

    @PostMapping(value = "create_diet")
    @ResponseBody
    public void addEvent_diet(@RequestBody EventDto eventTextDto, Principal principal) throws Exception {
        String eventType = eventTextDto.getEventType();
        String title = eventTextDto.getTitle();
        String food_name = eventTextDto.getFood_name();
        String kcal = eventTextDto.getKcal();
        String carbohydrate = eventTextDto.getCarbohydrate();
        String protein = eventTextDto.getProtein();
        String fat = eventTextDto.getFat();
        String sugar = eventTextDto.getSugar();
        String salt = eventTextDto.getSalt();
        String cholesterol = eventTextDto.getCholesterol();
        String saturatedFattyAcids = eventTextDto.getSaturatedFattyAcids();
        String transFattyAcids = eventTextDto.getTransFattyAcids();


        String start = eventTextDto.getStart();
        String end = eventTextDto.getEnd();
        boolean allDay = eventTextDto.isAllDay();
        String username = principal.getName();
        Member member = memberRepository.findByEmail(username);


        Event eventDiet = EventDto.builder()
                .eventType(eventType)
                .title(title)
                .food_name(food_name)
                .kcal(kcal)
                .carbohydrate(carbohydrate)
                .protein(protein)
                .fat(fat)
                .sugar(sugar)
                .salt(salt)
                .cholesterol(cholesterol)
                .saturatedFattyAcids(saturatedFattyAcids)
                .transFattyAcids(transFattyAcids)
                .start(start)
                .end(end)
                .allDay(allDay)
                .member(member)
                .build().toEntity_diet();

        eventService.saveEvent(eventDiet);

    }

    @GetMapping("getpxapi/{start}/{end}")
    @ResponseBody
    public String getPxApi(@PathVariable Long start, @PathVariable Long end) throws IOException {
        String serviceKey = "3733313631313630353532323832313332";
        String resultType = "json";
        String service = "DS_MND_PX_PARD_PRDT_INFO";
        String string_url = "https://openapi.mnd.go.kr/" + serviceKey + "/" + resultType + "/" + service + "/" + start + "/" + end;
        URL url = new URL(string_url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        BufferedReader rd;

        // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        return sb.toString();

    }

    @GetMapping("getpxapi/{start}/{end}/{search}")
    @ResponseBody
    public String getPxApi(@PathVariable Long start, @PathVariable Long end, @PathVariable String search) throws IOException {
        String serviceKey = "3733313631313630353532323832313332";
        String resultType = "json";
        String service = "DS_MND_PX_PARD_PRDT_INFO";
        String string_url = "https://openapi.mnd.go.kr/" + serviceKey + "/" + resultType + "/" + service + "/" + start + "/" + end;
        URL url = new URL(string_url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        BufferedReader rd;

        // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        return sb.toString();

    }


    @DeleteMapping(value = "delete")
    @ResponseBody
    public void deleteEvent(@RequestBody EventDto eventTextDto, Principal principal) throws Exception {
        Long id = eventTextDto.getId();
        eventService.deleteEvent(id);
    }

}
