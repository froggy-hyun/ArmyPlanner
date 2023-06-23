package ArmyPlanner.spring.repository;

import ArmyPlanner.spring.domain.Event;
import ArmyPlanner.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByMember(Member member);

    void deleteById(Long id);


}
