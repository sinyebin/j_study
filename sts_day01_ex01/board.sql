Create table users(
	ID varchar2(8) primary key,
	password varchar2(8),
	name varchar2(20),
	role varchar2(5)
);

insert into users values('test','test123','관리자','admin');
insert into users values('user1','user1','홍길동','user');
select*from users;

create table board_ex(
	seq number(5) primary key,
	title varchar2(200),
	writer varchar2(20),
	content varchar2(2000),
	regdate date default now(),
	cnt number(5) default 0 
)

insert into board_ex(seq,title,writer,content) values(1,'가입인사','관리자','반갑습니다');

select*from board_ex;
commit;