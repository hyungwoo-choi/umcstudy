package umc.spring.study.apiPayload.code.status;

import lombok.Getter;
import umc.spring.study.apiPayload.code.BaseCode;
import umc.spring.study.apiPayload.code.ReasonDTO;

@Getter
public enum SuccessStatus implements BaseCode {
    _OK("OK", "200", true);

    private final String message;
    private final String code;
    private final boolean isSuccess;

    private SuccessStatus(String message, String code, boolean isSuccess){
        this.message = message;
        this.code = code;
        this.isSuccess = isSuccess;
    }

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

}
