package com.my.springboardgradle.repository;

import com.my.springboardgradle.domain.ArticleComment;
import com.my.springboardgradle.domain.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        // 기본적으로 이 Entity 안에 있는 기본 검색기능을 추가해준다.
        QuerydslPredicateExecutor<ArticleComment>,
        // 우리의 입맛에 맞는 검색기능을 위해 추가.
        QuerydslBinderCustomizer<QArticleComment> {
    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root) {
        // Listing 을 하지 않은 property 는 검색에서 제외시킨다.
        bindings.excludeUnlistedProperties(true);
        // 검색되기를 원하는 필드들을 추가한다.
        bindings.including(root.content, root.createdAt, root.createdBy);
//        bindings.bind(root.title).first(StringExpression::likeIgnoreCase);      // like '${v}'
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);

    }

}
