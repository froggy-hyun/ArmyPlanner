package ArmyPlanner.spring.service;

import ArmyPlanner.spring.domain.User;
import ArmyPlanner.spring.domain.UserSessionDto;
import ArmyPlanner.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final HttpSession session;

    /* 로그인 인증 - username DB에 존재여부 확인 */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username).orElseThrow(() ->
    new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + username));

    session.setAttribute("user", new UserSessionDto(user));

    /* 시큐리티 세션에 유저 정보 저장 */
    return new CustomUserDetails(user);
    }
}
