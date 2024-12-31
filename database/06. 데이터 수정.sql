------------------------------------
--데이터 수정(update)
------------------------------------
--기존에 저장되어 있는 데이터를 변경하는 작업
--update 테이블이름 set 변경코드 [where 조건];
--조건은 사실상 무조건 쓴다

--(ex) 모든 상품의 가격을 0원으로 변경
update product set price = 0;

--(ex) 모든 상품의 종류를 과자로, 가격을 100원으로 변경
update product set type = '과자', price = 100;

--(ex) 1번 상품의 가격을 1000원으로 변경 (가장 일반적인 형태)
update product set price = 1000 where no = 1;
--없어도 실행됨(적용행수가 0으로 표시)
update product set price = 1000 where no = 9999;

--Q1. 7번 상품의 이름을 '처음처럼', 가격을 1200원, 분류를 '주류'로 변경
update product set name='처음처럼', price=1200, type='주류' where no=7;

--Q2. 분류가 '과자'인 상품 가격을 200원 할인
--update product set price-=200 where type='과자';
update product set price = price-200 where type='과자';

--Q3. 분류가 '아이스크림'인 상품 가격을 10% 인상
update product set price = price*110/100 where type='아이스크림'

select * from product;
rollback;
