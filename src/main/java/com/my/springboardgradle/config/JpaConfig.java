package com.my.springboardgradle.config;

import com.my.springboardgradle.dto.security.BoardPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)    // Authentication 정보 불러오기
                .filter(Authentication::isAuthenticated)    // 인증이 되어있나 검사
                .map(Authentication::getPrincipal)          // 로그인 정보인 Principal 인증정보 불러오기 (Object 형태)
                .map(BoardPrincipal.class::cast)            // BoardPrincipal 타입으로 캐스팅
                .map(BoardPrincipal::getUsername);          // 유저정보 불러오기
    }
}
