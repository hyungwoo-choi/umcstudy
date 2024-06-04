package umc.spring.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.enums.*;
import umc.spring.study.domain.mapping.UserAgree;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.domain.mapping.UserPrefer;
import umc.spring.study.domain.mapping.Review;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Users extends BaseEntity {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private UserStatus status;

    private LocalDate inactivaDate;

    @Column(nullable = true, length = 50)
    private String email;

    private Integer point;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPrefer> userPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAgree> userAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Inquiry> InquiryList = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}