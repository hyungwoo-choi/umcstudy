package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.study.domain.Market;
import umc.spring.study.validation.annotation.ExistMarket;

public class OwnerRequestDTO {
    @Getter
    public static class AddMissionDTO{
        @NotNull
        String Body;
        @NotNull
        float reward;
        @NotNull
        @ExistMarket
        Market market;
    }
}
