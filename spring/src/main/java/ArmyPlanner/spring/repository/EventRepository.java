package ArmyPlanner.spring.repository;

import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByMember(Member member);

    void deleteById(Long id);


}
