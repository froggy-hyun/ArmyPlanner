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
    private String email; // 이메일

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String email, String password, String name, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }


    public static Member createMember(MemberRegistryDto memberRegistryDto, PasswordEncoder passwordEncoder){
        Member member = Member.builder()
                .email(memberRegistryDto.getEmail())
                .password(passwordEncoder.encode(memberRegistryDto.getPassword()))
                .name(memberRegistryDto.getName())
                .role(Role.MEMBER)
                .build();
        return member;
    }

}
