package ArmyPlanner.spring.domain;

import lombok.Getter;

import java.io.Serializable;

// 인증된 사용자 정보를 세션에 저장
@Getter
public class UserSessionDto implements Serializable {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Role role;

    /* Entity -> Dto */
    public UserSessionDto(User user) {
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.nickname = user.getNickname();
    this.email = user.getEmail();
    this.role = user.getRole();
    }
}
