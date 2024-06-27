package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.MissionConverter;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.Review;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.service.TempService.MarketQueryService;
import umc.spring.study.service.TempService.MissionCommandService;
import umc.spring.study.validation.annotation.ExistMarket;
import umc.spring.study.validation.annotation.ExistPage;
import umc.spring.study.web.dto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Mission")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    private final MarketQueryService marketQueryService;

    @PostMapping("/")
    public ApiResponse<OwnerResponseDTO.AddMissionResultDTO> addMissionAPI(@RequestParam @Valid OwnerRequestDTO.AddMissionDTO request){

//        Users user = userCommandService.joinUser(request);
        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }

    @GetMapping("/{marketId}/missions")
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissionList(@ExistMarket @PathVariable(name = "marketId") Long marketId,@ExistPage @RequestParam(name = "page") Integer page){

//        컨트롤러에서 인자를 받고 서비스에 던져주면 서비스에서 db에 접근하여 정보를 보내주면
//        그걸 dto로 바꿔서 ApiResponse로 던져준다 그
        Page<Mission> missionList = marketQueryService.getMissionList(marketId, page);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }

    @PostMapping("/try")
    public ApiResponse<UsersResponseDTO.TryMissionReseltDTO> tryMissionAPI(@RequestParam UsersRequestDTO.TryMissionDTO request){

        UserMission usermission = missionCommandService.tryMission(request);
        return ApiResponse.onSuccess(MissionConverter.toTryMissionResultDTO(usermission));
    }




}
