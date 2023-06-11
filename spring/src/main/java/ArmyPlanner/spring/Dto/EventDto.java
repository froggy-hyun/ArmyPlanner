package ArmyPlanner.spring.Dto;


import ArmyPlanner.spring.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private Long id;

    private String title;

    private String description;

    private String start;

    private String end;

    public Event toEntity() {
        return Event.builder()
                .title(title)
                .description(description)
                .start(LocalDateTime.parse(start))
                .end(LocalDateTime.parse(end))
                .build();
    }
}
