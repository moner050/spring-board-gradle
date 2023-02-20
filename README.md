# spring-board-gradle


# 게시판 API 설계

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