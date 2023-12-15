
drop table books;

create table books (
	book_code number not null primary key,
	title VARCHAR2(50),
	author VARCHAR2(30),
	year VARCHAR2(10),
	price NUMBER
);


insert into books values (1, '운영체제','kim','2018',35000);
insert into books values (2, 'C언어','park','2019',36000);
insert into books values (3, 'java','hong','2020',37000);
insert into books values (4, '자바','hong','2020',37000);
insert into books values (5, '쉬운 자바','hong','2021',38000);
insert into books values (6, '어려운 자바','hong','2022',39000);

commit;
