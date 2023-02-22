package com.my.springboardgradle.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[View][Get] 게시글 리스트 (게시판) 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingArticlesView_thenReturnArticlesView() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                // 타입이 TEXT_HTML 인지 확인
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                // 이 URL 에 해당한 뷰가 있어야 한다.
                .andExpect(view().name("articles/index"))
                // model 에 해당 키의 데이터가 있는지 확인
                .andExpect(model().attributeExists("articles"));
    }

    @DisplayName("[View][Get] 게시글 상세 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingArticleView_thenReturnArticleView() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                // 타입이 TEXT_HTML 인지 확인
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                // 이 URL 에 해당한 뷰가 있어야 한다.
                .andExpect(view().name("articles/detail"))
                // model 에 해당 키의 데이터가 있는지 확인
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));
    }

    @Disabled("구현 중")
    @DisplayName("[View][Get] 게시글 검색 전용 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingArticleSearchView_thenReturnArticleSearchView() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/article/search"))
                .andExpect(status().isOk())
                // 타입이 TEXT_HTML 인지 확인
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                // 이 URL 에 해당한 뷰가 있어야 한다.
                .andExpect(view().name("articles/search"));
    }

    @Disabled("구현 중")
    @DisplayName("[View][Get] 게시글 해시태그 검색 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingArticleHashtagSearchView_thenReturnArticleHashtagSearchView() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/article/search-hashtag"))
                .andExpect(status().isOk())
                // 타입이 TEXT_HTML 인지 확인
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                // 이 URL 에 해당한 뷰가 있어야 한다.
                .andExpect(view().name("articles/search-hashtag"));
    }
}
