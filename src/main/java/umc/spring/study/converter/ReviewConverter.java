package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.mapping.Review;
import umc.spring.study.web.dto.MarketRequestDTO;
import umc.spring.study.web.dto.MarketResponseDTO;
import umc.spring.study.web.dto.UsersRequestDTO;
import umc.spring.study.web.dto.UsersResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

//    review 인스턴스의 id를 받아와 DTO로 바꿔주는 메서드
//    여기는 entity 의 컬럼값과 똑같아야됨
    public static UsersResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review){
        return UsersResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .build();
    }

//    dto -> 엔티티
    public static Review toReview(UsersRequestDTO.AddReviewDTO request){
        return Review.builder()
//                dto로 받은 것을 entity객체로 바꿔줌
                .body(request.getBody())
                .score(request.getScore())
                .market(request.getMarket())
                .user(request.getUser())
                .build();
    }
    public static MarketResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return MarketResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getScore())
                .body(review.getBody())
                .build();
    }
    public static MarketResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<MarketResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());
        return MarketResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
