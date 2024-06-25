package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.MissionConverter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.service.TempService.MissionCommandService;
import umc.spring.study.web.dto.OwnerRequestDTO;
import umc.spring.study.web.dto.OwnerResponseDTO;
import umc.spring.study.web.dto.UsersRequestDTO;
import umc.spring.study.web.dto.UsersResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Mission")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<OwnerResponseDTO.AddMissionResultDTO> addMissionAPI(@RequestParam @Valid OwnerRequestDTO.AddMissionDTO request){

//        Users user = userCommandService.joinUser(request);
        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }

    @PostMapping("/try")
    public ApiResponse<UsersResponseDTO.TryMissionReseltDTO> tryMissionAPI(@RequestParam UsersRequestDTO.TryMissionDTO request){

        UserMission usermission = missionCommandService.tryMission(request);
        return ApiResponse.onSuccess(MissionConverter.toTryMissionResultDTO(usermission));


    }




}
