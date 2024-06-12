package umc.spring.study.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.mapping.Review;
import umc.spring.study.service.TempService.ReviewCommandService;
import umc.spring.study.web.dto.UsersRequestDTO;
import umc.spring.study.web.dto.UsersResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("Review")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<UsersResponseDTO.AddReviewResultDTO> addReviewAPI(@RequestParam @Valid UsersRequestDTO.AddReviewDTO request){
//        Users user = userCommandService.joinUser(request);
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }
}
