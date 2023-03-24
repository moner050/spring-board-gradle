package com.my.springboardgradle.config;

import com.my.springboardgradle.domain.UserAccount;
import com.my.springboardgradle.repository.UserAccountRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean private UserAccountRepository userAccountRepository;

    // 스프링 테스트를 할때에만 가능.
    // 테스트 메소드가 실행되기 전에 메소드가 실행됨
    @BeforeTestMethod
    public void securitySetUp() {
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(UserAccount.of(
                "lmhTest",
                "123qwe!",
                "lmh-test@email.com",
                "lmh-test",
                "test memo"
        )));
    }
}
