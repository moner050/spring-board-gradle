package com.my.springboardgradle.controller;

import com.my.springboardgradle.config.SecurityConfig;
import com.my.springboardgradle.config.TestSecurityConfig;
import com.my.springboardgradle.service.ArticleService;
import com.my.springboardgradle.service.PaginationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("View 컨트롤러 - 인증부분")
@Import(TestSecurityConfig.class)
@WebMvcTest(Void.class)
public class AuthControllerTest {

    private final MockMvc mvc;

    @MockBean private ArticleService articleService;
    @MockBean private PaginationService paginationService;

    public AuthControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[View][Get] 로그인 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenTryingToLogin_thenReturnLoginView() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/login"))
                .andExpect(status().isOk())
                // 타입이 TEXT_HTML 인지 확인
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
        then(articleService).shouldHaveNoInteractions();
        then(paginationService).shouldHaveNoInteractions();
    }
}
