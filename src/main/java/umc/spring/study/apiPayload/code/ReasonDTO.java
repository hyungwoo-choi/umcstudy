package umc.spring.study.apiPayload.code;

import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ReasonDTO {
    private HttpStatus httpStatus;
    private String message;
    private String code;
    private boolean isSuccess;
    // 성공코드 메세지 코드 성공여부 를 보내줌
}
