package umc.spring.study.service.TempService;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.Review;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.web.dto.OwnerRequestDTO;
import umc.spring.study.web.dto.UsersRequestDTO;

public interface MissionCommandService {
    Mission addMission(OwnerRequestDTO.AddMissionDTO request);

    UserMission tryMission(UsersRequestDTO.TryMissionDTO request);
}
