package ArmyPlanner.spring.Dto;


import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private Long id;

    private String eventType;

    private String title;

//  식단 -----------------------
    private String food_name;
    private String kcal;
    private String carbohydrate;
    private String protein;
    private String fat;
    private String sugar;
    private String salt;
    private String cholesterol;
    private String saturatedFattyAcids;
    private String transFattyAcids;

//  소비 기록 --------------------
    private String shopping_name;
    private String total_price;

//  장소 --------------------
    private String placeName;
    private String address;
    private String x;
    private String y;

    private String start;
    private String startDate;
    private String startMonth;
    private String end;

    private Member member;

    private boolean allDay;

    public Event toEntity_text() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.KOREA);

        return Event.builder()
                .eventType(eventType)
                .title(title)
                .start(LocalDateTime.parse(start, dateTimeFormatter))
                .end(LocalDateTime.parse(end, dateTimeFormatter))
                .allDay(allDay)
                .member(member)
                .build();

    }

    public Event toEntity_diet() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.KOREA);

        return Event.builder()
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
                .start(LocalDateTime.parse(start, dateTimeFormatter))
                .startDate(startDate)
                .end(LocalDateTime.parse(end, dateTimeFormatter))
                .allDay(allDay)
                .member(member)
                .build();

    }

    public Event toEntity_shopping() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.KOREA);

        return Event.builder()
                .eventType(eventType)
                .title(title)
                .shopping_name(shopping_name)
                .total_price(total_price)
                .start(LocalDateTime.parse(start, dateTimeFormatter))
                .startDate(startDate)
                .startMonth(startMonth)
                .end(LocalDateTime.parse(end, dateTimeFormatter))
                .allDay(allDay)
                .member(member)
                .build();

    }

    public Event toEntity_place() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.KOREA);

        return Event.builder()
                .eventType(eventType)
                .title(title)
                .placeName(placeName)
                .address(address)
                .x(x)
                .y(y)
                .start(LocalDateTime.parse(start, dateTimeFormatter))
                .startDate(startDate)
                .end(LocalDateTime.parse(end, dateTimeFormatter))
                .allDay(allDay)
                .member(member)
                .build();

    }
}