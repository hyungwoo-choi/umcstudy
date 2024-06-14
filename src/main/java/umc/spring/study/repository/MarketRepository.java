package umc.spring.study.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.Market;

import java.util.Optional;


@Repository
@Transactional

public interface MarketRepository extends JpaRepository<Market, Long>, MarketCustomRepository {

}
