# 스프링 게시판 서비스

## ⚙ 프로젝트 개발 환경
- 통합개발환경 : Intellij
- JDK 버전 : JDK 17
- 스프링부트 버전 : 2.7.8
- Gradle 버전 : 7.6
- 사용 DB : MySQL
- 빌드툴 : Gradle
- 관리툴 : Git, Github, GitKraken

## ⚒ 기술 스택
- Backend
    - Spring Boot
    - Spring Boot Actuator
    - Spring Web
    - Rest Repositories
    - Rest Repositories HAL Explorer
    - Spring Security
    - Spring Data Jpa
    - Spring Devtools
    - Spring Configuration Processor
    - Lombok
    - QueryDSL 5.0.0
    
- Database
    - MySQL 8.0.28
    - H2 Database
    
- FrontEnd
  - Thymeleaf
  - Bootstrap 5.3.0


## 📜 프로젝트 구현 기능
- 회원 (UserAccount)
  - 로그인 및 로그아웃
- 게시글 (Article)
  - 게시글 조회, 등록, 수정, 삭제
- 댓글 (ArticleComment)
  - 게시글 내의 댓글 조회, 등록, 수정, 삭제


## 게시판 API 설계

|종류|URL|Method|기능|입력 데이터|
|---|---|---|---|---|
|뷰|/|GET|메인 페이지||
|''|/error|GET|에러 페이지||
|''|/login|GET|로그인 페이지||
|''|/sign-up|GET|회원 가입 페이지||
|''|/articles|GET|게시판 페이지||
|''|/articles/{article-id}|게시글 페이지||
|''|/articles/search|GET|게시판 검색 전용 페이지||
|''|/articles/search-hashtag|GET|게시판 해시태그 검색 전용 페이지||
|API|/api/sign-up|POST|회원 가입|ID, PW, 이메일, 닉네임|
|''|/api/login|GET|로그인 요청|ID, PW|
|''|/api/articles|GET|게시글 리스트 조회|필터: 제목, 내용, ID, 닉네임, 해시태그|
|''|/api/articles/{article-id}|GET|게시글 단일 조회|''|
|''|/api/articles|POST|게시글 추가|제목, 내용, ID, 해시태그|
|''|/api/articles/{article-id}|PUT, PATCH|게시글 수정|제목, 내용, 해시태그|
|''|/api/articles/{article-id}|DELETE|게시글 삭제|게시글 ID|
|''|/api/articlesComments|GET|댓글 리스트 조회|필터: 댓글 내용, ID, 닉네임|
|''|/api/articlesComments/{article-comment-id}|GET|댓글 단일 조회|''|
|''|/api/articles/{article-id}/articleComments|GET|게시글에 연관된 댓글 리스트 조회|필터: 댓글 내용|
|''|/api/articles/{article-id}/articleComments/{article-comment-id}|GET|게시글에 연관된 댓글 단일 조회|''|
|''|/api/articles/{article-id}/articleComments|POST|댓글 등록|내용, 회원 ID|
|''|/api/articles/{article-id}/articleComments/{article-comment-id}|PUT, PATCH|댓글 수정|내용|
|''|/api/articles/{article-id}/articleComments/{article-comment-id}|DELETE|댓글 삭제|댓글 ID|
