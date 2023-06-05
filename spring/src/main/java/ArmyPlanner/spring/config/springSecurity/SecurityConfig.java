package ArmyPlanner.spring.config.springSecurity;

import ArmyPlanner.spring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor //CustomUserDetailsService 생성자 주입
@Configuration
@EnableWebSecurity //Web 기반 Security
@EnableGlobalMethodSecurity(prePostEnabled = true) //Method 기반 Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MemberService memberService;

    @Bean
    //BCryptPasswordEncoder : Spring Security 비밀번호 암호화 객체
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {

        //인증 무시 경로
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

    @Override
    //HttpSecurity : HTTP 요청에 대한 보안 구성
    protected void configure(HttpSecurity http) throws Exception {
//      http.csrf().disable(); //csrf 토큰 임시 비활성화
        http.authorizeRequests()
                .antMatchers("/","/registry","/login", "/css/**").permitAll()
                .antMatchers("/member/**").authenticated() // 일반사용자 접근 가능
                .antMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN") // 매니저, 관리자 접근 가능
                .antMatchers("/admin/**").hasRole("ADMIN"); // 관리자만 접근 가능
        // 인증 필요시 로그인 페이지와 로그인 성공시 리다이랙팅 경로 지정
        http.formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/", true).failureUrl("/login/error");
        // 인증된 사용자이지만 인가되지 않은 경로에 접근시 리다이랙팅 시킬 uri 지정
        http.exceptionHandling().accessDeniedPage("/forbidden");
        http.logout()// "/logout"에 접근하면 HTTP 세션 제거
                .logoutUrl("/logout") //로그아웃 url
                .logoutSuccessUrl("/") //로그아웃 성공 시 이동되는 페이지
                .invalidateHttpSession(true); //HTTP 세션을 초기화
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
}


