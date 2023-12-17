drop table score;
create table score(
    syudent_no VARCHAR2(20) primary key,
    name VARCHAR2(50) not null,
    kor number not null,
    eng NUMBER not null,
    mat NUMBER not null
);

insert into score values ('1','kim',90,80,70);
insert into score values ('2','kwon',100,90,80);
insert into score values ('3','lee',91,81,71);
insert into score values ('4','ahn',92,82,72);
insert into score values ('5','hong',95,85,75);

commit;