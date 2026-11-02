GitHub Organization Repository URL:https://github.com/2026-2-WebService/assign09-c01-22300644

Personal GitHub Repository URL:https://github.com/jangjong1203/assign09-22300644

Render Deployment URL:https://assign09-22300644.onrender.com
https://assign09-22300644.onrender.com/api/movie



① 프로젝트 소개

주제 및 주요 기능

    영화 정보를 관리하는 REST CRUD 웹프로젝트입니다.
    원격 MariaDB를 연동하고, Spring Data JPA를 이용하여 영화의 데이터를 
    등록, 조회, 수정, 삭제등이 가능합니다.

Entity 필드 구조
    
    id (Long): PRIMARY KEY

    title (String): 영화 제목 
    
    director (String): 감독 이름 
    
    rating (Double): 평점 
    
    genre (String): 장르 
    
    runningTime (Integer): 상영 시간(분) 

프로젝트 구조 및 개발환경

    프로젝트 구조: Controller → Service → JpaRepository → Hibernate → MariaDB

    개발 환경: Java 17, Spring Boot, Gradle, Spring Web, Spring Data JPA, MariaDB Driver, IntelliJ IDEA
    
    배포 환경: Docker, Render

GitHub Repository URL

    https://github.com/2026-2-WebService/assign09-c01-22300644
    
Render Deployment URL
    
    https://assign09-22300644.onrender.com

② Database SQL Practice

기존 Table 조회 및 데이터 추가 결과
        
    INSERT INTO product(name, price, category, stock) VALUES ('tissue', 42000, 'Household goods', 20);
    
    SELECT * FROM product;
    

새 Table 생성 SQL

    CREATE TABLE movie (
        movie_id BIGINT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(100) NOT NULL,
        director VARCHAR(100) NOT NULL,
        rating DOUBLE NOT NULL,
        genre VARCHAR(50)
    );

INSERT / UPDATE / DELETE / SELECT SQL

    INSERT INTO movie(title, director, rating, genre) VALUES ('Inception', 'Nolan', 9.1, 'SF'),
    ('Interstellar', 'Nolan', 9.3, 'SF'),
    ('Parasite', 'Bong', 9.0, 'Drama');
    
    UPDATE movie SET rating = 9.5 WHERE director = 'Bong';

    DELETE FROM movie WHERE title = 'Inception';

    SELECT * FROM movie;


DBeaver 실행 화면 또는 결과
    
    


③ Spring Data JPA 구현

Entity 및 JpaRepository 설명

    Entity : DBeaver 데이터베이스의 movieJPA 테이블과 매핑되는 자바 객체입니다.

    JpaRepository: JpaRepository<movie, Long>을 상속받아,SQL 쿼리를 직접 작성하지 않아도
    save(), findAll(), findById(), deleteById() 등의 메서드를 기본으로 사용할수있습니다.    

사용한 Annotation의 역할

    @Entity: 자바객체를 데이터베이스 테이블과 매핑시키고, JPA가 관리하는 클래스임을 나타냅니다.

    @Table: DB에 생성될 테이블 이름을 지정하거나 @Entity가 매핑되는 데이터베이스 테이블 이름을 지정해준다.
    
    @Id: Entity 클래스의 필드를 데이터베이스 테이블의 Primary Key에 매핑할 때 사용합니다.
    
    @GeneratedValue(strategy = GenerationType.IDENTITY): 기본키 생성을 데이터베이스에 위임합니다.
    
    @Column: DB 컬럼의 각 속성을 매핑합니다.



REST API Endpoint 목록 및 요청·응답 JSON
    
    POST /api/movies 영화 등록
    
    GET/api/movies 영화 전체 조회
    
    GET/api/movies/{id} 영화 선택 조회
    
    PUT/api/movies/{id} 영화 수정
    
    DELETE /api/movies/{id} 영화 삭제

    요청 JSON (POST / PUT)
    {
    "title": "Inception",
    "director": "Nolan",
    "rating": 9.5,
    "genre": "SF",
    "runningTime": 148
    }
    
    응답 JSON (선택,전체 조회, 등록 성공 시)

    {
    "id": 1,
    "title": "Inception",
    "director": "Nolan",
    "rating": 9.5,
    "genre": "SF",
    "runningTime": 148
    }

JPA Entity와 MariaDB Table 비교

    JPA Entity는 일단 자바 객체이고, MariaDB Table은 데이터베이스 입니다.
    JPA는 SQL문 작성없이 각기능을 구현가능하고, 비즈니스 로직을 수행하고 데이터를 객체 형태로 다루기 위해 사용합니다.
    MariaDB Table은 데이터를 저장하고 조회·정렬하기 위해 사용합니다.

④ JPA와 SQL 비교

save(), findAll(), findById(), deleteById() 사용 결과

실제 Hibernate SQL 확인

SQL을 직접 작성하는 방식과 JPA 방식의 차이

    SQL 직접 작성은 테이블 구조 변경 시 모든 쿼리를 일일이 수정해야 합니다.
    반면, JPA는 객체 중심으로 코드를 작성하면 Hibernate가 데이터베이스 종류에 맞는 최적의 SQL을 자동으로 생성해줍니다.

⑤ 배포 및 환경 설정

IntelliJ 및 Render 환경변수 설정 방법(변수명만 기록)

    DB_URL, DB_USERNAME, DB_PASSWORD 를 environment variables에 값을 추가해서 설정을 해줍니다.
    
Render 배포 과정
    
    dockerfile을 추가해주고, 개인 깃허브 저장소와 렌더를 연결해줍니다. 이후  연결에 성공했다면 나온 주소에 접속하여 확인합니다.

배포 URL의 CRUD 테스트 결과

    Postman을 이용하여테스트 했습니다.



MariaDB 데이터 저장 확인

    DBeaver에서 테이블에 데이터가 들어있는지 확인했습니다.


발생한 문제와 해결 방법
    
    render와 연결을 할때 environment variables를 intellij에만 추가하면 되는줄알고 넣지않아서
    오류가 발생했습니다. ai의 도움을 받아 environment variables를 추가하고 실행하니 잘 작동하였습니다.

⑥ Weekly Report

    Key Learning: 새롭게 이해한 내용 3가지

    이전에는 SQL 문을 직접 쓰지않고, JPA를 활용하여 @Entity로 자바와 DB 테이블을 짝지어 주고,
    SQL문 없이도 DB에 저장되고 조회하는 방법을을 배웠습니다.    

    환경변수 사용법: DB 비밀번호 같은 중요한 정보는 코드에 바로 적지 않고, ${DB_PASSWORD}처럼 환경변수로 만든 다음,
    따로 설정에서 값을 주입하는 안전한 방식과 그렇게 해야하는 이유를 배웠습니다

    어노테이션 사용법: 각종 JPA 어노테이션의 사용법에 대해 이해했습니다.

Problem & Solution: 문제 1개 이상과 해결 과정

    JPA에 익숙하지 않아서 어노테이션 들과 작동 방식이 헷갈렸습니다.
    교수님이 주신 샘플코드와 강의 자료들을 참고하여 코드들을 작성하고 이해하기위해 노력했습니다.
    
   
 Code Review: 중요한 코드 1개와 동작 설명

    @Entity
    @Table(name="moviejpa")
    public class movie{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false,length = 100)
        private String title;
    }

    JPA를 배우는 이번주에 가장 중요한 내용을 들이 담겨잇다고 생각해서 골랐습니다.
    @Entity, @Table(name="moviejpa")으로 자바객체를 DB테이블과 매핑 시켜주고,
    @Id,@GeneratedValue(strategy = GenerationType.IDENTITY),@Column 으로 테이블의 요소들과 동일한
    속성과 이름을 가진 자바 객체들을 생성해준다. 

AI Usage: AI 활용 내용 및 직접 수정·검증한 부분, 자신이 생각하는 AI사용률(%)
    
    AI를 오류가 발생하거나 테스트를 진행할떄 연결하는법 등 기본설정들에대해 활용했습니다.
    각 코드들과 SQL문들은 예전에 작성한 코드들이나 샘플 코드들을 참고하여 직접 작성했습니다.
    20%: 생각보다 오류가 많이 발생하였고, 연결을 할때 헷갈리는 부분이 많았던것 같습니다.

Reflection: 추가로 공부하고 싶은 내용

    실제 Hibernate SQL 확인 부분을 ai및 강의자료를 활용하여 이해해보려고 했으나 잘 되지않아 결국 진행하지 못했습니다.
    관련내용을 더 공부해보고싶습니다.