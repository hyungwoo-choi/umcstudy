package umc.spring.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.repository.MarketRepository;
import umc.spring.study.validation.annotation.ExistMarket;
import umc.spring.study.validation.annotation.ExistPage;

import java.util.List;
@Component
@RequiredArgsConstructor
public class PageExistValidator implements ConstraintValidator<ExistPage, Integer> {


    private final MarketRepository marketRepository;

    @Override
    public void initialize(ExistPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer values, ConstraintValidatorContext context) {
        boolean isValid = true;
        if(values < 0){
            isValid = false;
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus._PAGE_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
