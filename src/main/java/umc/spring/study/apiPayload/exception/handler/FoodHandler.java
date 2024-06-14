package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.exception.GeneralException;

public class FoodHandler extends GeneralException {
    // 아래 BaseErrorCode 형태는 객체 ErrorStatus이다.
    public FoodHandler(BaseErrorCode errorCode) {

        super(errorCode);
    }
}

