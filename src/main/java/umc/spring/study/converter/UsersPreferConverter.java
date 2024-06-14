package umc.spring.study.converter;

import umc.spring.study.domain.Food;
import umc.spring.study.domain.mapping.UserPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class UsersPreferConverter {
    public static List<UserPrefer> toUserPreferList(List<Food> foodList) {
        return foodList.stream()
                .map(foodCategory ->
                        UserPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
