package umc.spring.study.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.mapping.Review;
import umc.spring.study.service.TempService.ReviewCommandService;
import umc.spring.study.validation.annotation.ExistMarket;
import umc.spring.study.web.dto.MarketResponseDTO;
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

    @GetMapping("/{marketId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MarketResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistMarket @PathVariable(name = "marketId") Long marketId){
        return null;
    }

}
