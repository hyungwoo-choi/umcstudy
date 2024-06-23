package umc.spring.study.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.MarketHandler;
import umc.spring.study.converter.MissionConverter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.repository.MarketRepository;
import umc.spring.study.repository.MissionRepository;
import umc.spring.study.repository.UserMissionRepository;
import umc.spring.study.web.dto.OwnerRequestDTO;
import umc.spring.study.web.dto.UsersRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MarketRepository marketRepository;
    private final MissionRepository missionRepository;

    private final UserMissionRepository userMissionRepository;


    public Mission addMission(OwnerRequestDTO.AddMissionDTO request){
        Mission newMission = MissionConverter.toMission(request);
        // 가게가 있는지 없는지 찾음
        Optional<Long> marketIdOptional = marketRepository.findMarketIdByMarket(request.getMarket());
        Long marketId = marketIdOptional.orElseThrow(() -> new MarketHandler(ErrorStatus._MARKET_NOT_FOUND));

        return missionRepository.save(newMission);
    }

    public UserMission tryMission(UsersRequestDTO.TryMissionDTO request){
        UserMission userMission = MissionConverter.toTryMission(request);
        return userMissionRepository.save(userMission);
    }

}
