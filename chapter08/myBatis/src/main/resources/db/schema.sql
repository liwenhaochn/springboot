drop table if exists `mybatis`;
drop table if exists `user`;
create table `user`
(
    `id`   int(11) not null auto_increment,
    `name` varchar(255) default null,
    `age`  int(11) default null,
    primary key (`id`)
)