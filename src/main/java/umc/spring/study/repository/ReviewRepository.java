package umc.spring.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Market;
import umc.spring.study.domain.mapping.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByMarket(Market market, PageRequest pageRequest);
}
