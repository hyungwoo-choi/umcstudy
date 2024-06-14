package umc.spring.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
    //temp 관련 응답
    _TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "THIS IS TEST!"),
    // 음식카테고리 관련 응답
    _FOOD_NOT_FOUND(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),

    _MARKET_NOT_FOUND(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


//    두개가 필요한 이유가 뭘까?

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
