

select * from board;

create table board (
seq number(5) primary key,
title varchar2(200),
writer varchar2(20),
content varchar2(2000),
regdate date default now(),
cnt number(5) default 0
);

INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT)
VALUES ((select nvl(max(seq),0)+1 from board), 'newtitle','newwriter','newcontent');

UPDATE BOARD SET TITLE='좋아요', WRITER='이순신', CONTENT='게시판 좋아요' WHERE SEQ=3;

DELETE FROM board_ex WHERE SEQ=9;

SELECT * FROM BOARD WHERE SEQ=2;

SELECT * FROM BOARD ORDER BY SEQ DESC;

commit




