package umc.spring.study.web.dto;

import lombok.Getter;

import java.util.List;

public class UsersRequestDTO {
    @Getter
//    가입결과 요청에 대한 정보
    public static class JoinDto{
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        List<Long> preferCategory;
    }
}
