package umc.spring.study.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import umc.spring.study.domain.Market;

import java.util.Optional;

public class MarketCustomRepositoryImpl implements MarketCustomRepository{
    @Autowired
    EntityManager entityManager;
    public Optional<Long> findMarketIdByMarket(Market market){
        String jpql = "select market.id from Market market where market = :market";
        Long marketId = entityManager.createQuery(jpql, Long.class)
                .setParameter("market", market)
                .getSingleResult();
        return Optional.ofNullable(marketId);
    }

//    public Long countReivewsByMarket(Market market){
//        String jpql = "select count(review) from Review review where review.market = :market";
//        Long reviews = entityManager.createQuery(jpql, Long.class)
//                .setParameter("market", market)
//                .getSingleResult();
//        return reviews;

//    }
}
