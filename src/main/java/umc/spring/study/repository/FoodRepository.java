package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.Food;
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}