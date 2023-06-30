package ArmyPlanner.spring.service;

import ArmyPlanner.spring.domain.LikedPlace;
import ArmyPlanner.spring.repository.LikedPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikedPlaceService {

    private final LikedPlaceRepository likedPlaceRepository;

    public LikedPlace saveLikedPlace(LikedPlace likedPlace) {

        return likedPlaceRepository.save(likedPlace);
    }
}
