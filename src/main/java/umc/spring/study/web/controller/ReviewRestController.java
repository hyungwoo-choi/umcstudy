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
//    POST 전송을 받게 되면

    public ApiResponse<UsersResponseDTO.AddReviewResultDTO> addReviewAPI(@RequestParam @Valid UsersRequestDTO.AddReviewDTO request){
//        Users user = userCommandService.joinUser(request);
//        서비스계층을 거친 리뷰는 저장된 새로운 객체를 반환하는것임-
//        거기서 성공적으로 레포지토리에 저장된 객체를 반환함.
        Review review = reviewCommandService.addReview(request);
//        성공적으로 저장된 객체를 성공되었다는 httpstatuscode로, 상태로 반환해줘야됨
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
//        ReivewConverter.toAddReviewResultDTO 라는
//        스태틱 메서드를 사용하여
//        onSuccess 메서드를 이용하여 성공했다는 반응의 객체를 보내주는것임
//        ApiResponse<> 는 객체를 만드는 것이고
//        ApiResponse 는 스태틱 메서드를 쓰기위해 그냥 클래스만 적어두는것이다.
    }

}
