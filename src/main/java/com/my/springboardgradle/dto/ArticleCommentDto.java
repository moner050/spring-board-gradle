package com.my.springboardgradle.dto;

import com.my.springboardgradle.domain.Article;
import com.my.springboardgradle.domain.ArticleComment;
import com.my.springboardgradle.domain.UserAccount;

import java.time.LocalDateTime;


public record ArticleCommentDto(
        Long id,
        Long articleId,
        UserAccountDto userAccountDto,
        String content,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static ArticleCommentDto of(Long id, Long articleId, UserAccountDto userAccountDto, String content, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleCommentDto(id, articleId, userAccountDto, content, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    // 영속화 되지 않은 정보를 Entity 에 만들어 놓기 전까지 못넣는 정보들을 null 로 넣을수 있는 팩토리 메서드
    public static ArticleCommentDto of(Long articleId, UserAccountDto userAccountDto, String content) {
        return new ArticleCommentDto(null, articleId, userAccountDto, content, null, null, null, null);
    }

    public static ArticleCommentDto from(ArticleComment articleComment) {
        return new ArticleCommentDto(
                articleComment.getId(),
                articleComment.getArticle().getId(),
                UserAccountDto.from(articleComment.getUserAccount()),
                articleComment.getContent(),
                articleComment.getCreatedAt(),
                articleComment.getCreatedBy(),
                articleComment.getModifiedAt(),
                articleComment.getModifiedBy()
        );

    }

    public ArticleComment toEntity(Article article, UserAccount userAccount) {
        return ArticleComment.of(
                article,
                userAccount,
                content
        );

    }
}
