package ArmyPlanner.spring.service;

import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.domain.SecurityUser;
import ArmyPlanner.spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    /* 로그인 인증 - username DB에 존재여부 확인 */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username).orElseThrow(() ->
        new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + username));

        log.info("loadUserByUsername member.username = {}", username);

        return new SecurityUser(member);
    }
}
