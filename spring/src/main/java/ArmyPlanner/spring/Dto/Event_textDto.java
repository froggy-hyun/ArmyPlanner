package ArmyPlanner.spring.Dto;


import ArmyPlanner.spring.domain.Event_text;
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
public class Event_textDto {

    private Long id;

    private String eventType;

    private String title;

//    private String description;

    private String start;

    private String end;

    private Member member;

    private boolean allDay;

    public Event_text toEntity() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.KOREA);
        return Event_text.builder()
                .title(title)
//                .description(description)
                .start(LocalDateTime.parse(start, dateTimeFormatter))
                .end(LocalDateTime.parse(end, dateTimeFormatter))
                .allDay(allDay)
                .member(member)
                .build();
    }

}
