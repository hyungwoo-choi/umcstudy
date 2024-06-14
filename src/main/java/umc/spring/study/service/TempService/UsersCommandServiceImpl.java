package umc.spring.study.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.FoodHandler;
import umc.spring.study.converter.UsersConverter;
import umc.spring.study.converter.UsersPreferConverter;
import umc.spring.study.domain.Food;
import umc.spring.study.domain.Users;
import umc.spring.study.domain.mapping.UserPrefer;
import umc.spring.study.repository.FoodRepository;
import umc.spring.study.repository.UsersRepository;
import umc.spring.study.web.dto.UsersRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UsersCommandServiceImpl implements UsersCommandService{

    private final UsersRepository userRepository;

    private final FoodRepository foodRepository;
    @Override
    @Transactional
    public Users joinUser(UsersRequestDTO.JoinDto request){

        Users newUser = UsersConverter.toUser(request);

        List<Food> foodList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new FoodHandler(ErrorStatus._FOOD_NOT_FOUND));
                }).collect(Collectors.toList());
//        입력받은 음식리스트가 카테고리에 있는지 확인후
        List<UserPrefer> userPreferList = UsersPreferConverter.toUserPreferList(foodList);

//          userPrefer 는 각 객체인건가?
        userPreferList.forEach(userPrefer -> {userPrefer.setUser(newUser);});

        return userRepository.save(newUser);
    }

}
