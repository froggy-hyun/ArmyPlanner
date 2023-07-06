package ArmyPlanner.spring.service;

import ArmyPlanner.spring.Dto.LikedPlaceDto;
import ArmyPlanner.spring.Dto.LikedPlaceXYDto;
import ArmyPlanner.spring.domain.LikedPlace;
import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.repository.LikedPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LikedPlaceService {

    private final LikedPlaceRepository likedPlaceRepository;

    public List<LikedPlaceDto> listAllLikedPlace(Member member) {
        List<LikedPlace> list = likedPlaceRepository.findAllByMember(member);

        List<LikedPlaceDto> likedPlacesDto = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            LikedPlaceDto likedPlaceDto = new LikedPlaceDto();

            likedPlaceDto.setId(list.get(i).getId());
            likedPlaceDto.setTitle(list.get(i).getTitle());
            likedPlaceDto.setRoadAddressName(list.get(i).getRoadAddressName().toString());
            likedPlaceDto.setX(list.get(i).getX().toString());
            likedPlaceDto.setY(list.get(i).getY().toString());

            likedPlacesDto.add(likedPlaceDto);
        }

        return likedPlacesDto;
    }

    public LikedPlaceXYDto findLikedPlaceXY(Member member, String placeName, String address) {
        LikedPlace likedPlace = likedPlaceRepository.findByMemberAndTitleAndRoadAddressName(member, placeName, address);

        LikedPlaceXYDto likedPlaceXYDto = new LikedPlaceXYDto(likedPlace.getX(), likedPlace.getY());

        return likedPlaceXYDto;
    }

    public LikedPlace saveLikedPlace(LikedPlace likedPlace) {
        return likedPlaceRepository.save(likedPlace);
    }

    public void deleteLikedPlace(Member member, String placeName, String address) {
        likedPlaceRepository.deleteByMemberAndTitleAndRoadAddressName(member, placeName, address);
    }
}
