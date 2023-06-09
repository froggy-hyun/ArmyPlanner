package ArmyPlanner.spring.Dto;

import lombok.Data;


@Data
public class EventDto {

    private Long id;

    private String title;

    private String description;

    private String start;

    private String end;
}
