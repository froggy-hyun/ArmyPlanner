package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.EventDto;
import ArmyPlanner.spring.Dto.LikedPlaceDto;
import ArmyPlanner.spring.Dto.LikedPlaceXYDto;
import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.repository.MemberRepository;
import ArmyPlanner.spring.service.EventService;
import ArmyPlanner.spring.service.LikedPlaceService;
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
    private final LikedPlaceService likedPlaceService;

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
    public void addEvent_diet(@RequestBody EventDto eventDietDto, Principal principal) throws Exception {
        String eventType = eventDietDto.getEventType();

        String title = eventDietDto.getTitle();

        String food_name = eventDietDto.getFood_name();
        String kcal = eventDietDto.getKcal();
        String carbohydrate = eventDietDto.getCarbohydrate();
        String protein = eventDietDto.getProtein();
        String fat = eventDietDto.getFat();
        String sugar = eventDietDto.getSugar();
        String salt = eventDietDto.getSalt();
        String cholesterol = eventDietDto.getCholesterol();
        String saturatedFattyAcids = eventDietDto.getSaturatedFattyAcids();
        String transFattyAcids = eventDietDto.getTransFattyAcids();


        String start = eventDietDto.getStart();
        String startDate = eventDietDto.getStartDate();
        String end = eventDietDto.getEnd();
        boolean allDay = eventDietDto.isAllDay();
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
                .startDate(startDate)
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


    @DeleteMapping(value = "delete")
    @ResponseBody
    public void deleteEvent(@RequestBody EventDto eventDto, Principal principal) throws Exception {
        Long id = eventDto.getId();
        eventService.deleteEvent(id);
    }

    @PostMapping(value = "create_shopping")
    @ResponseBody
    public void addEvent_shopping(@RequestBody EventDto eventShoppingDto, Principal principal) throws Exception {
        String eventType = eventShoppingDto.getEventType();

        String title = eventShoppingDto.getTitle();

        String shopping_name = eventShoppingDto.getShopping_name();
        String totalPrice = eventShoppingDto.getTotal_price();

        String start = eventShoppingDto.getStart();
        String startDate = eventShoppingDto.getStartDate();
        String startMonth = eventShoppingDto.getStartMonth();
        String end = eventShoppingDto.getEnd();
        boolean allDay = eventShoppingDto.isAllDay();
        String username = principal.getName();
        Member member = memberRepository.findByEmail(username);


        Event eventShopping = EventDto.builder()
                .eventType(eventType)
                .title(title)
                .shopping_name(shopping_name)
                .total_price(totalPrice)
                .start(start)
                .startDate(startDate)
                .startMonth(startMonth)
                .end(end)
                .allDay(allDay)
                .member(member)
                .build().toEntity_shopping();

        eventService.saveEvent(eventShopping);
    }

    @GetMapping("getLikedPlace")
    @ResponseBody
    public List<LikedPlaceDto> getLikedPlace(Principal principal) {
        String username = principal.getName();
        Member member = memberRepository.findByEmail(username);

        return likedPlaceService.listAllLikedPlace(member);
    }

    @PostMapping(value = "create_place")
    @ResponseBody
    public void addEvent_place(@RequestBody EventDto eventPlaceDto, Principal principal) throws Exception {
        String eventType = eventPlaceDto.getEventType();

        String title = eventPlaceDto.getTitle();
        String placeName = eventPlaceDto.getPlaceName();
        String address = eventPlaceDto.getAddress();
        String x = eventPlaceDto.getX();
        String y = eventPlaceDto.getY();

        String start = eventPlaceDto.getStart();
        String startDate = eventPlaceDto.getStartDate();
        String end = eventPlaceDto.getEnd();
        boolean allDay = eventPlaceDto.isAllDay();

        String username = principal.getName();
        Member member = memberRepository.findByEmail(username);

        Event eventPlace = EventDto.builder()
                .eventType(eventType)
                .title(title)
                .placeName(placeName)
                .address(address)
                .x(x)
                .y(y)
                .start(start)
                .startDate(startDate)
                .end(end)
                .allDay(allDay)
                .member(member)
                .build().toEntity_place();

        eventService.saveEvent(eventPlace);
    }

    @GetMapping("/getLikedPlaceXY/{placeName}")
    @ResponseBody
    public LikedPlaceXYDto getLikedPlaceXY(@PathVariable String placeName, Principal principal) throws IOException {
        String username = principal.getName();
        Member member = memberRepository.findByEmail(username);

        return likedPlaceService.findLikedPlaceXY(member, placeName);

    }

}
