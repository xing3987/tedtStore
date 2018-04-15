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
update t_user set gender=1 where username='aaaaaaaaa';

create table t_address(
	id int auto_increment primary key,
	uid int not null,
	recv_name varchar(50) not null,
	recv_province varchar(6),
	recv_city varchar(6) not null,
	recv_area varchar(6) not null,
	recv_distric varchar(100) not null,
	recv_address varchar(100) not null,
	recv_phone varchar(32) not null,
	recv_tel varchar(32),
	recv_zip varchar(6),
	recv_tag varchar(10),
	created_user varchar(50),
	created_time date,
	modified_user varchar(50),
	modified_time date
)engine=InnoDB default charset=utf8;

desc t_address;

select * from t_dict_cities;
select * from t_dict_areas;
select * from t_dict_provinces;
select id,province_code,province_name from t_dict_provinces;







