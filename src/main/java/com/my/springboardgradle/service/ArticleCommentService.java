package com.my.springboardgradle.service;

import com.my.springboardgradle.dto.ArticleCommentDto;
import com.my.springboardgradle.repository.ArticleCommentRepository;
import com.my.springboardgradle.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComments(Long articleId) {
        return List.of();
    }

    public void deleteArticleComment(Long articleCommentId) {

    }

    public void updateArticleComment(ArticleCommentDto dto) {
    }

    public void saveArticleComment(ArticleCommentDto dto) {

    }
}
