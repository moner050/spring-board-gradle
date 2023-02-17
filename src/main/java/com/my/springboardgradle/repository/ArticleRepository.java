package com.my.springboardgradle.repository;

import com.my.springboardgradle.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}