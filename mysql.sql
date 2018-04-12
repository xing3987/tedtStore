show tables;
drop table t_user;
create table t_user(
	id int auto_increment primary key,
	username varchar(50) not null unique,
	password varchar(50) not null,
	email varchar(50) not null,
	phone varchar(32) not null,
	image varchar(100),
	gender int comment '0表示男,1表示女',
	created_user varchar(50),
	created_time date,
	modified_user varchar(50),
	modified_time date
)engine=innoDB default charset=utf8;

desc t_user;
select * from t_user;
truncate table t_user;
insert into t_user values(null,null,"111111","aaaaaa@aa.com","11111111111",null,1,"111111",null,null,null);
