package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    // 아래 BaseErrorCode 형태는 객체 ErrorStatus이다.
    public TempHandler(BaseErrorCode errorCode) {

        super(errorCode);
    }
}
