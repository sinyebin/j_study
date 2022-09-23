drop table blog;

create table blog(
	id number not null primary key,
	title varchar2(100) not null,
	writer varchar2(50) not null,
	content varchar2(1000)
);

drop sequence seq_blog;
create sequence seq_blog start with 1 increment by 1;
select seq_blog.nextval from dual;
select seq_blog.currval from dual;

insert into blog(id,title,writer,content)
values(seq_blog.nextval, 'test','tester','test...');

commit

select*from blog