package ArmyPlanner.spring.repository;

import ArmyPlanner.spring.domain.Event_text;
import ArmyPlanner.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event_text, Long> {

    List<Event_text> findAllByMember(Member member);

    void deleteById(Long id);


}
