package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.exception.GeneralException;

public class MarketHandler extends GeneralException {
    // 아래 BaseErrorCode 형태는 객체 ErrorStatus이다.
    public MarketHandler(BaseErrorCode errorCode) {

        super(errorCode);
    }
}

