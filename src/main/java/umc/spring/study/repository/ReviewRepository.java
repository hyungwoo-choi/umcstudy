package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.mapping.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
