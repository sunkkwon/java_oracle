drop table member;
create table member(
    userid VARCHAR2(50) not null primary key,
    passwd VARCHAR2(50) not null,
    name VARCHAR2(50) not null,
    email VARCHAR2(50),
    hp VARCHAR2(50),
    zipcode VARCHAR2(5),
    address1 VARCHAR2(200),
    address2 VARCHAR2(200),
    join_date DATE default sysdate
);

insert into member (userid,passwd,name,email) values ('kim','1234','김철수','kim@naver.com');
insert into member (userid,passwd,name,email) values ('kwon','1234','권철수','kim@naver.com');
insert into member (userid,passwd,name,email) values ('hong','1234','홍철수','kim@naver.com');
insert into member (userid,passwd,name,email) values ('kang','1234','강철수','kim@naver.com');
insert into member (userid,passwd,name,email) values ('lee','1234','이철수','kim@naver.com');
insert into member (userid,passwd,name,email) values ('park','1234','박철수','kim@naver.com');

select * from member;

commit;