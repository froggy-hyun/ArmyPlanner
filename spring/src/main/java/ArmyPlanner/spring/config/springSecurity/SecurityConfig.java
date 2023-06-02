package ArmyPlanner.spring.config.springSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity //Web 기반 Security
@EnableGlobalMethodSecurity(prePostEnabled = true) //Method 기반 Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {

        //인증 무시 경로
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }
}


