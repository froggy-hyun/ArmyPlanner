package ArmyPlanner.spring.repository;

import ArmyPlanner.spring.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
