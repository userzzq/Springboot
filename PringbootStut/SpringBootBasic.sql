use information_schema;
drop database if exists SpringBootBasic;
create database SpringBootBasic default charset utf8 collate utf8_general_ci;
use SpringBootBasic;

create table TbUser
(
 uid int auto_increment primary key comment '用户id,主键',
 username varchar(50) unique comment '用户名',
 password varchar(20) comment '密码',
 nickname varchar(200) comment '昵称',
 isEnable enum('y','n') default 'y' comment '是否启用，y：启用（默认）n:停用',
 regDate timestamp default now() null comment '注册时间'
);
/*添加默认用户*/
insert into TbUser(username,password,nickname)
values('niko','28938','求来气玩');

select * from TbUser;

/*用户Token追踪表*/
create table TbToKenInfo
(
 token varchar(50) primary key comment '令牌值，自然主健',
 uid int comment '令牌对应的用户，可以是null,表示用户还没有登陆',
 lastupdate timestamp comment'令牌环最后更新时间'
);

select * from TbToKenInfo;