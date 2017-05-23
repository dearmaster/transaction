create table user_balance_tbl(username varchar(20) not null, balance float);

insert into user_balance_tbl(username, balance) values ('张三', 100);
insert into user_balance_tbl(username, balance) values ('李四', 100);

drop table user_balance_tbl;


select * from user_balance_tbl;