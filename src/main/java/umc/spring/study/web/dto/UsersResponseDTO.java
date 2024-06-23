package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
//    리뷰 결과
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddReviewResultDTO{
        Long reviewId;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TryMissionReseltDTO{
        Long userMissionId;
    }
}
