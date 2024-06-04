package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
