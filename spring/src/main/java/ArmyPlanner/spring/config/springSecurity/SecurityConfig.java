package ArmyPlanner.spring.config.springSecurity;

import ArmyPlanner.spring.service.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor //CustomUserDetailsService 생성자 주입
@Configuration
@EnableWebSecurity //Web 기반 Security
@EnableGlobalMethodSecurity(prePostEnabled = true) //Method 기반 Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailService customUserDetailService;

    @Bean
    //BCryptPasswordEncoder : Spring Security 비밀번호 암호화 객체
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    // AuthenticationManager(인증처리)를 생성하기 위해 AuthenticationManagerBuilder 사용
    // passwordEncoder : AuthenticationManager에게 어떤 해쉬로 암호화했는지 알려줌
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(encoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        //인증 무시 경로
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

    @Override
    //HttpSecurity : HTTP 요청에 대한 보안 구성
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //csrf 토큰 임시 비활성화
                .authorizeRequests()
                .antMatchers("/", "/auth/**", "/posts/read/**", "/posts/search/**") //경로 지정
                .permitAll() //권한 없이 접근 가능
                .anyRequest() //그 외의 경로
                .authenticated() //인증된 사용자만 접근 가능
                .and()
                .formLogin() //form 기반 인증 - "/login" -> Spring Security 로그인 Form 사용
                .loginPage("/auth/login") //기본 로그인 Form이 아닌 커스텀 로그인 폼 사용
                .loginProcessingUrl("loginProc") //Security에서 해당 주소로 오는 요청을 낚아채서 수행
                .defaultSuccessUrl("/") //로그인 성공 시 이동되는 페이지
                .and()
                .logout()// "/logout"에 접근하면 HTTP 세션 제거
                .logoutSuccessUrl("/") //로그아웃 성공 시 이동되는 페이지
                .invalidateHttpSession(true); //HTTP 세션을 초기화
    }
}


