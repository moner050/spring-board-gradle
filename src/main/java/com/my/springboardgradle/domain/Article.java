package com.my.springboardgradle.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Article extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 유저 정보 (ID)
    @Setter @ManyToOne(optional = false) @JoinColumn(name = "userId") private UserAccount userAccount;

    @Setter @Column(nullable = false) private String title;                           // 제목
    @Setter @Column(nullable = false, length = 10000) private String content;         // 본문

    @Setter private String hashtag;                                                   // 해시태그

    // 순환참조 방지를 위해 끊어주기
    @ToString.Exclude
    // 생성일자 기준으로 정렬하겠다.
    @OrderBy("createdAt DESC")
    // 기본값으로 지정해주면 두개의 Entity 이름을 합치기 때문에 mappedBy 로 명시
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    // Article 에 연동되어있는 Comment 는 중복을 허용하지 않고 List 로 보겠다.
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    protected Article() {
    }

    private Article(UserAccount userAccount, String title, String content, String hashtag) {
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of (UserAccount userAccount, String title, String content, String hashtag) {
        return new Article(userAccount, title, content, hashtag);
    }

    // 객체의 동일성, 동등성 검사를 위한 equals, hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        // 아직 영속화하지 않은 Entity 는 동등성 검사 탈락 (다른 값으로 보겠다.)
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
