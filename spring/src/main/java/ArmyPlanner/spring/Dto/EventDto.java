package ArmyPlanner.spring.Dto;


import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

//    private String description;

    private String start;

    private String end;

    private Member member;

    private boolean allDay;

    public Event toEntity() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.KOREA);
            if (eventType == "text") {
                return Event.builder()
                        .eventType(eventType)
                        .title(title)
                        .start(LocalDateTime.parse(start, dateTimeFormatter))
                        .end(LocalDateTime.parse(end, dateTimeFormatter))
                        .allDay(allDay)
                        .member(member)
                        .build();
            } else if (eventType == "diet") {
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
                        .end(LocalDateTime.parse(end, dateTimeFormatter))
                        .allDay(allDay)
                        .member(member)
                        .build();
            }
        return null;
    }

}
