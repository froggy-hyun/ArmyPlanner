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
    private String roadAddressName;
    private Member member;

    private String x;
    private String y;


    public LikedPlace toEntity() {

        return LikedPlace.builder()
                .title(title)
                .roadAddressName(roadAddressName)
                .x(x)
                .y(y)
                .member(member)
                .build();
    }
}
