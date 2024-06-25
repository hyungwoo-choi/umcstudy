package umc.spring.study.service.TempService;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Market;
import umc.spring.study.domain.mapping.Review;

import java.util.Optional;

public interface MarketQueryService {
    Optional<Market> findMarket(Long id);

    Page<Review> getReviewList(Long MarketId, Integer page);
}
