package ArmyPlanner.spring.domain;

import ArmyPlanner.spring.controller.MemberRegistryDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
@Getter
public class Member{

//    @Id
//    // @GeneratedValue(strategy = GenerationType.IDENTITY)
//    // sqlite-jdbc 버그 해결
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
//    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String username; // 아이디

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static Member createMember(MemberRegistryDto memberRegistryDto, PasswordEncoder passwordEncoder){
        Member member = Member.builder()
                .username(memberRegistryDto.getUsername())
                .password(passwordEncoder.encode(memberRegistryDto.getPassword()))
                .role(Role.ROLE_MEMBER)
                .build();
        return member;
    }

}
