package ArmyPlanner.spring.Dto;


import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private Long id;

    private String title;

//    private String description;

    private String start;

    private String end;

    private Member member;

    private boolean allDay;

    public Event toEntity() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.KOREA);
        return Event.builder()
                .title(title)
//                .description(description)
                .start(LocalDateTime.parse(start, dateTimeFormatter))
                .end(LocalDateTime.parse(end, dateTimeFormatter))
                .allDay(allDay)
                .member(member)
                .build();
    }

}
