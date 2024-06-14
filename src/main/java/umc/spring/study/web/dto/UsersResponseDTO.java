package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class UsersResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
//    가입결과에 대한 DTO
    public static class JoinResultDTO{
        Long userId;
        LocalDateTime createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddReviewResultDTO{
        Long reviewId;
    }
}
