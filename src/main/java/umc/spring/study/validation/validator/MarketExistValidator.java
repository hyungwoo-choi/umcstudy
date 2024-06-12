package umc.spring.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.repository.MarketRepository;
import umc.spring.study.validation.annotation.ExistMarket;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MarketExistValidator implements ConstraintValidator<ExistMarket, List<Long>>{

    private final MarketRepository marketRepository;
    @Override
    public void initialize(ExistMarket constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> marketRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus._MARKET_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}