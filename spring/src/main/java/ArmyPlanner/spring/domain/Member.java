package ArmyPlanner.spring.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MEMBER")
@Getter
public class Member{

//    @Id
//    // @GeneratedValue(strategy = GenerationType.IDENTITY)
//    // sqlite-jdbc 버그 해결
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
//    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Id @GeneratedValue
    private Long id;

    private String username; // 아이디

    private String password;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String username, String password, boolean enabled, Role role) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }
}
