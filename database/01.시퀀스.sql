
drop table pokemon;
create table pokemon(
pokemon_no number(10) primary key,
POKEMON_name varchar2(30) not null,
POKEMON_type varchar2(9) not null,
check(pokemon_type in ('불', '풀', '땅', '물', '바람'))
);

drop sequence pokemon_seq;
create sequence pokemon_seq;

insert into POKEMON(POKEMON_NO, POKEMON_NAME, POKEMON_TYPE)
values(pokemon_seq.nextval, '리자몽', '불');
commit;
select * from pokemon;

--Q.기존에 만든 테이블 중에서 시퀀스가 필요하다면 생성한 뒤 데이터 등록
-- country, player, menu, item, phone, game_user, lecture



drop table country;
create table country(
country_no number primary key,
country_name varchar2(45) not null unique,
country_capital varchar2(45) not null unique,
country_population number not null,
check(regexp_like(country_name, '^[가-힣]{1,15}$')),
check(country_population > 0)
);

drop sequence country_seq;
create sequence country_seq;

insert into country(country_no, country_name, country_capital, country_population)
values(country_seq.nextval, '한국', '서울', '50000000');
commit;
select * from country;


drop table menu;
create table menu(
menu_no number primary key,
menu_name varchar2(60) not null unique,
menu_type varchar2(15) not null,
menu_price number not null,
menu_event char(1) not null,
check(menu_type in ('음료','디저트','아이스크림','식사','케이크')),
check(menu_price >= 0),
check(menu_event in ('Y', 'N'))
);

drop sequence menu_seq;
create sequence menu_seq;

insert into menu(menu_no, menu_name, menu_type, menu_price, menu_event)
values(menu_seq.nextval, '파르페', '디저트', '14000', 'N');
commit;
select * from menu;


drop table item;
create table item (
item_no number primary key,
item_name varchar2(60) not null,
item_type varchar2(15) not null,
item_price number not null,
item_discount_rate number(3,2),
item_qty number default 0 not null,
item_early char(1) default 'N' not null,
check(item_type in ('식품','잡화','의류','장난감','생필품','스포츠','주방','전자제품')),
check(item_price >= 0),
check(item_discount_rate between 0 and 1),
check(item_qty >= 0),
check(item_early in ('Y','N'))
);

drop sequence item_seq;
create sequence item_seq;

insert into item(item_no, item_name, item_type, item_price, item_discount_rate, item_qty, item_early)
values(item_seq.nextval, '후라이팬', '잡화', '35000', '0.3', '4', 'N');

select * from item;


drop table phone;
create table phone (
phone_no number primary key,
phone_name varchar2(60) not null,
phone_telecom varchar2(45) not null,
phone_price number not null,
phone_contract number,
check(phone_price >= 0),
check(phone_contract in (24, 30, 36))
);

drop sequence phone_seq;
create sequence phone_seq;

insert into phone(phone_no, phone_name, phone_telecom, phone_price, phone_contract)
values(phone_seq.nextval, '아이폰15', 'SK', '12000000', '24');
commit;
select * from phone;



drop table game_user;
create table game_user (
game_user_no number primary key,
game_user_id varchar2(24) not null unique,
game_user_job varchar2(9) not null,
game_user_level number default 1 not null,
game_user_money number default 0 not null,
check(regexp_like(game_user_id, '^[A-Za-z0-9가-힣]{1,8}$')),
check(game_user_job in ('전사','성직자','도적')),
check(game_user_level > 0),
check(game_user_money >= 0)
);

drop sequence game_user_seq;
create sequence game_user_seq;

insert into game_user(game_user_no, game_user_id, game_user_job, game_user_level, game_user_money)
values(game_user_seq.nextval, 'sita0628','전사','3','20000');
commit;
select * from game_user;


drop table lecture;
create table lecture (
lecture_no number primary key,
lecture_name varchar2(90) not null,
lecture_category varchar2(30) not null,
lecture_period number not null,
lecture_price number default 0 not null,
lecture_type varchar2(12) default '오프라인' not null,
check(lecture_period > 0),
check(lecture_price >= 0),
check(lecture_type in ('온라인', '오프라인', '혼합'))
);

drop sequence lecture_seq;
create sequence lecture_seq;

insert into lecture(lecture_no, lecture_name, lecture_category, lecture_period, lecture_price, lecture_type)
values(lecture_seq.nextval, '자바 프로그래밍', 'IT', '6', '300000', '온라인');
commit;
select * from lecture;

