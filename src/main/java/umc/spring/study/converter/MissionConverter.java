package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.Review;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.web.dto.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .marketName(mission.getMarket().getName())
                .body(mission.getBody())
                .reward(mission.getReward())
                .build();

    }
    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());
        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

}
