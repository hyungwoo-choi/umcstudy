package umc.spring.study.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.MarketHandler;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.Market;
import umc.spring.study.domain.mapping.Review;
import umc.spring.study.repository.MarketRepository;
import umc.spring.study.repository.ReviewRepository;
import umc.spring.study.web.dto.UsersRequestDTO;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

//    private final MarketRepository
    private final ReviewRepository reviewRepository;
    private final MarketRepository marketRepository;
    @Override
    @Transactional

//    addReview 메서드 완성시켜야됨, 어노테이션 완성
    public Review addReview(UsersRequestDTO.AddReviewDTO request){
//        dto -> entity
        Review newReview = ReviewConverter.toReview(request);
//
////        가게가 있는지 없는지 찾음
//        Long marketId = marketRepository.findMarketIdByMarket(request.getMarket())
//                .orElseThrow(() -> new MarketHandler(ErrorStatus._MARKET_NOT_FOUND));

        // 가게가 있는지 없는지 찾음
        Optional<Long> marketIdOptional = marketRepository.findMarketIdByMarket(request.getMarket());
        Long marketId = marketIdOptional.orElseThrow(() -> new MarketHandler(ErrorStatus._MARKET_NOT_FOUND));

        return reviewRepository.save(newReview);
//        Review 타입의 newReview 를 반환함
    }
}
