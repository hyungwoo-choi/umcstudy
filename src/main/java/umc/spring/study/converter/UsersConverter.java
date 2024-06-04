package umc.spring.study.converter;

import umc.spring.study.domain.Users;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.web.dto.UsersRequestDTO;
import umc.spring.study.web.dto.UsersResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UsersConverter {

    public static UsersResponseDTO.JoinResultDTO toJoinResultDTO(Users user){
        return UsersResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Users toUser(UsersRequestDTO.JoinDto request){
        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }
        return Users.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .userPreferList(new ArrayList<>())
                .build();
    }
}