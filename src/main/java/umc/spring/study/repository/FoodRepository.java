package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}