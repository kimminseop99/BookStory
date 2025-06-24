<div align="center">
  <img src="https://github.com/user-attachments/assets/e598f589-d80c-4b64-ba59-cd3245d40d38" alt="BookStory_logo" />
</div>


# 독후감 작성 사이트
<br><br>
# 🚩 프로젝트 정보
- DB PORT : 3307
- DB username : root
- 데이터베이스 이름 : Bookstory

# 💬 프로젝트 설명
 - Spring Boot와 Thymeleaf 기반의 웹 애플리케이션으로, 사용자가 책에 대한 감상과 해시태그를 포함한 리뷰를 작성하고 공유할 수 있는 서비스입니다.
 - 회원가입, 로그인, 댓글, 마이페이지, 비밀글 기능을 통해 사용자 맞춤 경험을 제공합니다.
 - IT Bookstore API를 활용해 인기 책을 불러오고, 반응형 디자인으로 모바일에서도 최적화된 UI를 제공합니다.

# 💨 개발 기간
- 2025 4.12 ~ 2025 6.13

# 🛠 개발 환경
- 운영체제 : Windows 10, 11
- 통합개발환경(IDE) : IntelliJ
- JDK 버전 : JDK 21
- 데이터 베이스 : MySQL
- 빌드 툴 : Gradle
- 관리 툴 : GitHub

# ✨ Dependencies
- Spring Boot DevTools
- Lombok
- Spring Data JPA
- MariaDB Driver
- Spring Security
- Spring Web
- Thymeleaf
- Validation

# 💻 기술 스택

### Version Control
<div>
    <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
    <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
</div>

### Backend Technologies
<div>
    <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
    <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
    <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white">
</div>

### Frontend Technologies
<div>
    <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
    <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">
    <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">
    <img src="https://img.shields.io/badge/Tailwind CSS-06B6D4?style=for-the-badge&logo=tailwindcss&logoColor=white">
    <img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
</div>

### Databases
<div>
    <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
    <img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white">
</div>


# 👥 개발자
|                                                               **김민섭**                                                            |
|:------------------------------------------------------------------------------------------------------------------------------------:|
| [<img src="https://avatars.githubusercontent.com/u/161572638?v=4" height=150 width=150> <br/> @kimminseop99](https://github.com/kimminseop99) | 


# 🗃️ ER 다이어그램
![BookStory_DB](https://github.com/user-attachments/assets/6e1ef308-bfa2-4368-b901-1499ed940827)


# 👤 주요 기능

📚 1. 독후감 작성 및 열람 기능
→ 사용자가 책 제목과 저자 기반으로 독후감을 작성하고, 다른 사람의 글을 검색·열람할 수 있습니다.

🔐 2. 로그인 기반의 사용자 권한 관리
→ 로그인한 사용자만 글을 작성·수정·삭제할 수 있고, 비밀글도 설정 가능합니다.

💬 3. 댓글, 해시태그, 마이페이지 기능
→ 댓글을 통한 소통, 해시태그 필터링, 마이페이지에서 내 글과 비밀번호 변경도 가능합니다.

# ⚙️ 페이지별 기능

🏠 1. 메인 페이지 (/)

 - 인기 독후감 리스트 또는 최신 독후감 리스트 출력
 - 검색창으로 제목/작성자/해시태그 검색
 - 로그인 여부에 따라 메뉴 다르게 표시
<br><br>

📖 2. 독후감 목록 페이지 (/review/list)

 - 전체 독후감 목록 페이징 출력
 - 해시태그 필터 기능
 - 검색 기능 (제목, 작성자)
<br><br>

📝 3. 독후감 작성 페이지 (/review/create)

 - 로그인한 사용자만 접근 가능
 - 제목, 저자, 내용, 해시태그 입력
 - 비밀글 설정 가능
<br><br>

📄 4. 독후감 상세 페이지 (/review/detail/{id})

 - 해당 글의 전체 내용 보기
 - 댓글 기능: 작성/수정/삭제
 - 작성자 본인만 글 수정/삭제 가능
 - 비밀글이면 본인 외에는 접근 제한
<br><br>

✏️ 5. 독후감 수정 페이지 (/review/modify/{id})

 - 작성자 본인만 접근 가능
 - 기존 정보 불러와 수정 가능
<br><br>

👤 6. 마이페이지 (/user/mypage)

 - 내가 작성한 독후감 목록
 - 비밀번호 변경 기능
<br><br>

💬 7. 고객센터 (/support/faq, /support/inquiry)

 - 자주 묻는 질문(FAQ) 페이지
 - 1:1 문의 등록 기능
<br><br>

🔐 8. 회원 관련 페이지 (/user/login, /user/signup)

 - 로그인 / 로그아웃
 - 회원가입
<br><br>

# 👍 프로젝트 후기

### 🕴️ 김민섭
재밌다
