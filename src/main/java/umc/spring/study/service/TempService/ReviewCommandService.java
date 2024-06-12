package umc.spring.study.service.TempService;

import umc.spring.study.domain.mapping.Review;
import umc.spring.study.web.dto.UsersRequestDTO;

public interface ReviewCommandService {
    Review addReview(UsersRequestDTO.AddReviewDTO request);
}
