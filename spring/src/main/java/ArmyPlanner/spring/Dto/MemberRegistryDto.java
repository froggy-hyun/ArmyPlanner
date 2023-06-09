package ArmyPlanner.spring.Dto;

import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Data
public class MemberRegistryDto {

    // @NotBlank : null, "", " " 모두 허용x

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 6, max = 16, message = "비밀번호는 6자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{3,10}$", message = "이름은 특수문자 제외 3자이상 10자이하로 입력해주세요.")
    private String name;

    @Pattern(regexp = "^^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", message = "휴대폰 번호 양식이 아닙니다.(xxx-xxxx-xxxx)")
    private String phone;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .role(Role.MEMBER)
                .build();
    }
}
