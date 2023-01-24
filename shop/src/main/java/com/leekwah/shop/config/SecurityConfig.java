package com.leekwah.shop.config;

import com.leekwah.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MemberService memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/members/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/members/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .logoutSuccessUrl("/");

        http.authorizeRequests() // 시큐리티 처리에 HttpServletRequest 를 이용한다는 걸 의미
                .mvcMatchers("/", "/members/**", "/item/**", "images/**").permitAll() // permitAll() 메서드를 통해서 인증(로그인)없이 경로에 접근가능
                .mvcMatchers("/admin/**").hasRole("ADMIN") // /admin 으로 설정해둔 경로는 ADMIN ROLE이 있어야 가능
                .anyRequest().authenticated();

        http.exceptionHandling() // 인증되지 않은 사용자가 리소스에 접근시 수행되는 핸들러 등록
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception { // static 디렉터리 하위 파일은 인증 무시하도록 설정
        web.ignoring().antMatchers("/css/**", "/js/**", "img/**");
    }
}

