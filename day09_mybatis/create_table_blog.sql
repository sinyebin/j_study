-- bno, title, writer, regDate
drop table blog;
create table blog (
   bno int primary key, 
   title varchar2(50), 
   writer varchar2(20), 
   regDate varchar2(20)
);

insert into blog(bno, title, writer, regDate)
values (101, 'test', 'tester', formatdatetime(now(), 'yyyy-MM-dd'));

insert into blog(bno, title, writer, regDate)
values (102, 'test2', 'tester2', formatdatetime(now(), 'yyyy-MM-dd'));

insert into blog(bno, title, writer, regDate)
values (103, 'test3', 'tester3', formatdatetime(now(), 'yyyy-MM-dd'));

commit;

select*from blog;