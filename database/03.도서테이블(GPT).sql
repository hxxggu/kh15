-- 기존 테이블 및 시퀀스 삭제
drop table book;
drop sequence book_seq;

-- book 테이블 생성
CREATE TABLE book(
    book_id NUMBER PRIMARY KEY,
    book_title VARCHAR2(300) NOT NULL,
    book_author VARCHAR2(90),
    book_publication_date CHAR(10),
    book_price NUMBER NOT NULL,
    book_publisher VARCHAR2(90),
    book_page_count NUMBER NOT NULL,
    book_genre VARCHAR2(30) NOT NULL,
    CHECK(REGEXP_LIKE(book_author, '^[^!@#$]+$')),
    CHECK(REGEXP_LIKE(
        book_publication_date, 
        '^([0-9]{4})-((02-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$'
    )),
    CHECK(book_price >= 0),
    CHECK(book_page_count > 0)
);

-- 시퀀스 생성
CREATE SEQUENCE book_seq;

-- book 테이블에 더미 데이터 삽입

BEGIN
    FOR i IN 1..1000 LOOP
        INSERT INTO book (
            book_id,
            book_title,
            book_author,
            book_publication_date,
            book_price,
            book_publisher,
            book_page_count,
            book_genre
        ) VALUES (
            book_seq.NEXTVAL, -- 시퀀스를 이용한 기본 키 생성
            '테스트도서' || TO_CHAR(i), -- 책 제목 (문자열)
            '저자' || TO_CHAR(MOD(i, 50) + 1), -- 저자 이름 (문자열)
            TO_CHAR(
                TRUNC(
                    SYSDATE - DBMS_RANDOM.VALUE(1, 365 * 24) -- 과거 24년 내 랜덤 날짜
                ),
                'YYYY-MM-DD'
            ), -- 출판일 (문자열 형식)
            TRUNC(DBMS_RANDOM.VALUE(1000, 50000), -2), -- 가격 (숫자, 100원 단위)
            '출판사' || TO_CHAR(MOD(i, 20) + 1), -- 출판사 이름 (문자열)
            TRUNC(DBMS_RANDOM.VALUE(100, 1000)), -- 페이지 수 (양의 정수)
            CASE MOD(i, 6) 
                WHEN 0 THEN '판타지'
                WHEN 1 THEN '소설'
                WHEN 2 THEN '역사'
                WHEN 3 THEN '과학'
                WHEN 4 THEN '교양'
                WHEN 5 THEN '에세이'
            END -- 장르 (문자열)
        );
    END LOOP;
    COMMIT;
END;


select * from book;
