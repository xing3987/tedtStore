show tables;
drop table t_user;
create table t_user(
	id int auto_increment primary key,
	username varchar(50) not null unique,
	password varchar(50) not null,
	email varchar(50) not null,
	phone varchar(32) not null,
	image varchar(100),
	gender int comment '0��ʾ��,1��ʾŮ',
	created_user varchar(50),
	created_time date,
	modified_user varchar(50),
	modified_time date
)engine=innoDB default charset=utf8;

desc t_user;
select * from t_user;
