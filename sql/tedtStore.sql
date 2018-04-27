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
select distinct password from t_user;
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
	recv_district varchar(100) not null,
	recv_address varchar(100) not null,
	recv_phone varchar(32) not null,
	recv_tel varchar(32),
	recv_zip varchar(6),
	recv_tag varchar(10),
	created_user varchar(50),
	created_time date,
	modified_user varchar(50),
	modified_time date,
	deafault_address int(1)
)engine=InnoDB default charset=utf8;
alter table t_address change deafault_address default_address int(1);
drop table t_address;
truncate table t_address;
desc t_address;
select * from t_address;
update t_address set default_address=1 where id=12;
delete from t_address where uid=11;
select * from t_dict_cities;
select * from t_dict_areas;
select * from t_dict_provinces;
select id,province_code,province_name from t_dict_provinces;


desc t_goods_category;
select * from t_address where uid=11;
desc t_goods;
select * from t_goods;
select * from t_goods_category;
select * from t_goods_category where parent_id=161;
select * from t_goods_category where parent_id=0;

create table t_cart(
	id int auto_increment primary key,
	uid int not null,
	goods_id varchar(200),
	count int,
	created_user varchar(50),
	created_time date,
	modified_user varchar(50),
	modified_time date
)engine InnoDB default charset=utf8

select * from t_cart;
desc t_cart;

--订单表
create table t_order(
	id int auto_increment primary key,
	tradeTime date,
	uid int,
	created_user varchar(50),
	created_time date,
	modified_user varchar(50),
	modified_time date
)default charset=utf8
drop table t_order;
select * from t_order;
select max(id) from t_order;
desc t_order;
truncate table t_order;
--订单详情表
create table t_orderItem(
	id int auto_increment primary key,
	uid int,
	goodsId varchar(200),
	image varchar(100),
	title varchar(50),
	price int,
	count int,
	paymentStatus int,
	orderStatus int,
	orderId int,
	created_user varchar(50),
	created_time date,
	modified_user varchar(50),
	modified_time date
)default charset=utf8

desc t_orderItem;
truncate table t_orderItem;
select * from t_orderItem;

--数据库编程（存储过程pl/sql）
delimiter $$
create procedure selectById(idIn int)
begin	
	select * from t_orderItem where id=idIn;
end$$

delimiter $$
	create procedure updateItem(poid int)
	begin
	update t_orderItem set paymentStatus=1 where orderId=poid;
end$$;
--调用函数
call updateItem(7);
call selectById(4);
--删除函数
drop procedure selectById;




