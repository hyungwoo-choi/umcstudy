package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.UsersConverter;
import umc.spring.study.domain.Users;
import umc.spring.study.service.TempService.UsersCommandService;
import umc.spring.study.web.dto.UsersRequestDTO;
import umc.spring.study.web.dto.UsersResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Users")
public class UserRestController {

    private final UsersCommandService userCommandService;
//파라미터로 유저에 관한 값을 넘겨주면 응답을 해주는 컨트롤러임
    @PostMapping("/")
    public ApiResponse<UsersResponseDTO.JoinResultDTO> joinAPI(@RequestParam @Valid UsersRequestDTO.JoinDto request){
        Users user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UsersConverter.toJoinResultDTO(user));
    }
}
