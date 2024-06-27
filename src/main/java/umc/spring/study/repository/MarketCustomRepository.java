package umc.spring.study.repository;

import umc.spring.study.domain.Market;

import java.util.Optional;

public interface MarketCustomRepository {
    Optional<Long> findMarketIdByMarket(Market market);
//    public Long countReivewsByMarket(Market market);
}
