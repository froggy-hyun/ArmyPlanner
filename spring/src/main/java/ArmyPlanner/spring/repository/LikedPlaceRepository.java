package ArmyPlanner.spring.repository;

import ArmyPlanner.spring.domain.LikedPlace;
import ArmyPlanner.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikedPlaceRepository extends JpaRepository<LikedPlace, Long> {
    List<LikedPlace> findAllByMember(Member member);

    void deleteById(Long id);

}
