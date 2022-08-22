create table saram(
id int primary key auto_increment,
name varchar2(20) not null,
phone varchar2(20),
email varchar2(100)
);

insert into saram (name,phone,email) values('HONG','010-1111-1111','hong@aaa.com');

insert into saram (name,phone,email) values('KIM','010-1111-1111','kim@aaa.com');

select * from saram;

commit;