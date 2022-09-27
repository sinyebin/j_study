drop table board;

create table board(
	num number not null primary key,
	author varchar2(100) not null,
	email varchar2(200) not null,
	title varchar2(500) not null,
	content varchar2(4000) not null,
	passwd varchar2(12) not null,
	writeday date,
	readcnt number,
	rep_root number,
	rep_step number,
	rep_indent number
);

drop sequence seq_board;
create sequence seq_board start with 1 increment by 1;

commit

select * from board;