--------------------------------------------------
-- 데이터 조회(select)
--------------------------------------------------
-- 목적에 맞는 데이터를 찾는 것
-- SELECT 항목 FROM 테이블 [조건] [정렬];


-- [1] 원하는 항목만 조회할 수 있다
select book_title from book;
select book_price from book;
select book_title, book_price from book;
select * from book;--와일드카드(*)는 전체를 의미
select book.* from book;--와일드카드(*)는 전체를 의미
-- (Q) 한 페이지당 가격을 추가해서 조회
select book_title, book_price/book_page_count from book;
-- 별칭을 추가할 수 있다(쌍따옴표를 쓰면 띄어쓰기 가능하지만 의미가 없음)
select book_title "도서명", book_price/book_page_count "페이지당가격" 
from book;
select book_title 도서명, book_price/book_page_count 페이지당가격 
from book;
-- (Q) 책의 모든 정보를 조회하며 페이지당 가격을 추가로 계산해서 조회
select book.*, book_price/book_page_count 페이지당가격 from book;


-- [2] 조회에는 필터링 조건을 추가하여 원하는 항목만 가져올 수 있다.

-- 숫자와 관련된 조건
-- (ex) book_id 가 7인 도서를 조회 (* 비교 연산 중 같다는 자바와 표현방식이 다름)
select * from book where book_id = 7;
-- (ex) 가격이 2만원 이하인 도서를 조회
select * from book where book_price <= 20000;
-- (ex) 가격이 1만원대인 도서를 조회
select * from book where book_price >= 10000 and book_price < 20000;
select * from book where book_price >= 10000 and book_price <= 19999;
select * from book where book_price between 10000 and 19999;

-- 문자와 관련된 조건
-- (ex) 제목이 '어린왕자'인 도서를 조회
select * from book where book_title = '어린왕자';
-- (ex) 출판사가 '열린책들'인 도서를 조회
select * from book where book_publisher = '열린책들';
-- (ex) '마법사'가 제목에 포함된 도서를 조회 
-- instr은 위치를 찾는 명령이며, 위치는 1부터 시작(0이면 없다는 뜻)
-- like는 패턴을 찾는 연산자이며, %는 글자가 있어도 그만 없어도 그만이란 뜻
-- regexp_like는 정규표현식 검사 명령이며, 패턴에 의해서 탐지
-- instr이 전반적으로 우수한 성능을 보이지만, 상황에 따라 다른 명령도 사용
select * from book where instr(book_title, '마법사') > 0;--평균적으로 빠름 (자바의 indexOf)
select * from book where book_title like '%마법사%';--평균적으로 느림 (자바의 contains)
select * from book where regexp_like(book_title, '마법사');--평균적으로 느림

-- (중요) 시작 검사만큼은 like가 압도적으로 빠르다
select * from book where book_title like '해리포터%';-- 매우빠름
select * from book where instr(book_title, '해리포터') = 1;-- 보통

-- (ex) 제목이 숫자로만 이루어진 도서를 조회
select * from book where regexp_like(book_title, '^[0-9]+$');
select * from book where regexp_like(book_title, '^[가-힣]+$');

-- 날짜와 관련된 조건
-- date, timestamp는 변환이 필요 없음
-- 문자열인데 날짜가 들어있는 경우는 date나 timestamp로 바꿔서 사용 가능
-- to_date() 또는 to_timestamp() 사용

-- (ex) 2000년 이후에 출판된 도서를 조회
-- extract는 날짜에서 원하는 항목을 추출하는 명령(year, month, ...)
-- to_timestamp(항목, 형식) 으로 날짜형식의 문자열을 변환할 수 있다
-- 형식에 대소문자는 의미가 없으며 다음과 같은 기호가 사용
-- Y(연도), M(월), D(일), HH(12시간), HH24(24시간), MI(분), SS(초)
select * from book 
where extract(
	year from to_timestamp(book_publication_date, 'YYYY-MM-DD')
) >= 2000;

-- (Q) 여름(6, 7, 8월)에 출판된 도서를 조회
select * from book
where extract(
	month from to_timestamp(book_publication_date, 'YYYY-MM-DD')
) between 6 and 8;

select * from book
where extract(
	month from to_timestamp(book_publication_date, 'YYYY-MM-DD')
) in (6, 7, 8);

-- 특정 기간에 출판된 도서를 조회(두 개의 날짜 사이에 위치한 데이터)
-- (ex) 2010년 1월 1일부터 2020년 12월 31일까지
select * from book 
where to_timestamp(book_publication_date, 'YYYY-MM-DD') 
	between to_timestamp('2010-01-01', 'YYYY-MM-DD') 
	and to_timestamp('2020-12-31', 'YYYY-MM-DD');

-- 만약 시간까지 고려해야 한다면
select * from book 
where to_timestamp(book_publication_date, 'YYYY-MM-DD') 
	between 
		to_timestamp('2010-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS') 
		and 
		to_timestamp('2020-12-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS');

select * from book 
where to_timestamp(book_publication_date, 'YYYY-MM-DD') 
	between 
		to_timestamp('2010-01-01' || ' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') 
		and 
		to_timestamp('2020-12-31' || ' 23:59:59', 'YYYY-MM-DD HH24:MI:SS');

-- [3] 조회를 마친 데이터를 원하는 순서로 정렬할 수 있다

-- (ex) 모든 도서 정보를 도서번호 순으로 조회 (book_id ascending)
select * from book order by book_id;--안쓰면 asc
select * from book order by book_id asc;
select * from book order by book_id desc;

-- (Q) 모든 도서 정보를 가격이 낮은순으로 조회 (같으면 번호순)
select * from book order by book_price asc;
select * from book order by book_price asc, book_id asc;

-- (ex) 조건이랑 같이 사용할 수 있다(단, 정렬은 제일 마지막에 해야한다)

--select * from book order by book_price asc where book_price <= 30000; 
select * from book where book_price <= 30000 
order by book_price asc, book_id asc;

-- (Q) 도서를 최근 출판한 순서대로 조회 (단, 같으면 도서번호순)
select * from book 
order by to_timestamp(book_publication_date, 'YYYY-MM-DD') desc, book_id asc; 
