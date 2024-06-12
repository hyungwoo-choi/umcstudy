package umc.spring.study.converter;

import umc.spring.study.domain.mapping.Review;
import umc.spring.study.web.dto.UsersRequestDTO;
import umc.spring.study.web.dto.UsersResponseDTO;

public class ReviewConverter {
    public static UsersResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review){
        return UsersResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .build();
    }

    public static Review toReview(UsersRequestDTO.AddReviewDTO request){
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .market(request.getMarketId())
                .user(request.getUserId())
                .build();
    }
}
