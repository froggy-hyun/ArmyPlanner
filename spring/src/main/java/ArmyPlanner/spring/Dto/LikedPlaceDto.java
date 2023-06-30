package ArmyPlanner.spring.Dto;

import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.domain.LikedPlace;
import ArmyPlanner.spring.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikedPlaceDto {

    private Long id;

    private String title;
    private String road_address_name;
    private Member member;


    public LikedPlace toEntity() {

        return LikedPlace.builder()
                .title(title)
                .road_address_name(road_address_name)
                .member(member)
                .build();
    }
}
