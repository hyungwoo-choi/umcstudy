package umc.spring.study.domain.mapping;
// favoritefood
import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.Users;
import umc.spring.study.domain.Food;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Food foodCategory;

    public void setUser(Users user) {
        if(this.user != null)
            user.getUserPreferList().remove(this);
        this.user = user ;
        user.getUserPreferList().add(this);
    }
    public void setFood(Food food){
        this.foodCategory = food;
    }
}
