package umc.spring.study.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.Mission;

@Repository
@Transactional

public interface MissionRepository extends JpaRepository<Mission, Long> {

}
