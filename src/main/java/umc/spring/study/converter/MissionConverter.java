package umc.spring.study.converter;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.Review;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.web.dto.OwnerRequestDTO;
import umc.spring.study.web.dto.OwnerResponseDTO;
import umc.spring.study.web.dto.UsersRequestDTO;
import umc.spring.study.web.dto.UsersResponseDTO;

public class MissionConverter {
    public static OwnerResponseDTO.AddMissionResultDTO toAddMissionResultDTO(Mission mission){
        return OwnerResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .build();
    }

    public static Mission toMission(OwnerRequestDTO.AddMissionDTO request){
        return Mission.builder()
                .body(request.getBody())
                .reward(request.getReward())
                .market(request.getMarket())
                .build();
    }

    public static UserMission toTryMission(UsersRequestDTO.TryMissionDTO request){
        return UserMission.builder()
                .mission(request.getMission())
                .user(request.getUser())
                .build();
    }

    public static UsersResponseDTO.TryMissionReseltDTO toTryMissionResultDTO(UserMission userMission){
        return UsersResponseDTO.TryMissionReseltDTO.builder()
                .userMissionId(userMission.getId())
                .build();
    }

}
