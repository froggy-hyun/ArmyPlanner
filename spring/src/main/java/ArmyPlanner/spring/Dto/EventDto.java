package ArmyPlanner.spring.Dto;


import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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

    public Event toEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return Event.builder()
                .title(title)
//                .description(description)
                .start(LocalDate.parse(start, formatter))
                .end(LocalDate.parse(end, formatter))
                .member(member)
                .build();
    }

}
