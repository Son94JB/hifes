package hiFes.hiFes.repository.festival;

import hiFes.hiFes.domain.festival.StampMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StampMissionRepository extends JpaRepository<StampMission, Long> {
    List<StampMission> findByOrganizedFestival_festivalId(long festivalId);

}

