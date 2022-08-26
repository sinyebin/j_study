create table product(
	pno number primary key,
	pname varchar2(60),
	price number
)

create sequence seq_product start with 1000 increment by 1;

insert into product values(seq_product.nextVal, '보성홍차 아이스티',2000);

commit

select* from product