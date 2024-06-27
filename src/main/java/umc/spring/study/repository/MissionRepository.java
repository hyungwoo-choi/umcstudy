package umc.spring.study.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.Market;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.Review;

@Repository
@Transactional

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByMarket(Market market, PageRequest pageRequest);
}
