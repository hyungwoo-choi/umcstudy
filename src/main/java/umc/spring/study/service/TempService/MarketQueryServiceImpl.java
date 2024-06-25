package umc.spring.study.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.Market;
import umc.spring.study.domain.mapping.Review;
import umc.spring.study.repository.MarketRepository;
import umc.spring.study.repository.ReviewRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketQueryServiceImpl implements MarketQueryService{

    private final MarketRepository marketRepository;

    private final ReviewRepository reviewRepository;
    @Override
    public Optional<Market> findMarket(Long id){
        return marketRepository.findById(id);
    }
    @Override
    public Page<Review> getReviewList(Long MarketId, Integer page){
        Market market = marketRepository.findById(MarketId).get();
        Page<Review> MarketPage = reviewRepository.findAllByMarket(market, PageRequest.of(page, 10));
        return MarketPage;
    }
}
