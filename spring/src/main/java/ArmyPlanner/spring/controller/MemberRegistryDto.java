package ArmyPlanner.spring.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
public class MemberRegistryDto {

    // @NotBlank : null, "", " " 모두 허용x

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String username;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @Builder
    public MemberRegistryDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
