package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Market;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, Long> {
    Optional<Long> findIdByMarket(Market market);
}
