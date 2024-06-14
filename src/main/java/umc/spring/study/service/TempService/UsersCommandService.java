package umc.spring.study.service.TempService;

import umc.spring.study.domain.Users;
import umc.spring.study.web.dto.UsersRequestDTO;

public interface UsersCommandService {
    Users joinUser(UsersRequestDTO.JoinDto request);
}
