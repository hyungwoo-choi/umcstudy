package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.study.domain.Market;
import umc.spring.study.domain.Users;
import umc.spring.study.validation.annotation.ExistCategories;
import umc.spring.study.validation.annotation.ExistMarket;

import java.util.List;

public class UsersRequestDTO {
    @Getter
//    가입결과 요청에 대한 정보
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
    @Getter
    public static class AddReviewDTO{
        @NotNull
        String body;
        @NotNull
        float score;
        @NotNull
        Users user;
//        마켓인증확인해야됨 valid
        @NotNull
        @ExistMarket
        Market market;
    }
}

