create database library DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'library'@'%' IDENTIFIED BY '123456';

GRANT ALL ON library.* TO 'library'@'%';

use library;

create table library.library_book
(
    book_id          int auto_increment comment '图书id'
        primary key,
    book_name        varchar(64)  not null comment '图书名称',
    book_description varchar(128) null comment '图书描述',
    create_by        int          null comment '创建人id',
    create_time      datetime     null comment '创建时间',
    update_by        int          null comment '更新人id',
    update_time      datetime     null comment '更新时间'
)
    comment '图书馆图书表';

INSERT INTO library.library_book (book_id, book_name, book_description, create_by, create_time, update_by, update_time) VALUES (1, '《童年》', '作者是高尔基', 1, '2023-02-20 17:05:53', 1, '2023-02-20 17:12:50');
INSERT INTO library.library_book (book_id, book_name, book_description, create_by, create_time, update_by, update_time) VALUES (2, '《繁星·春水》', '作者是冰心', 1, '2023-02-20 17:05:53', 1, '2023-02-20 17:12:50');

create table library.library_group
(
    group_id    int auto_increment comment '用户组id'
        primary key,
    group_name  varchar(16)      null comment '用户组名',
    state       char default '1' null comment '''状态，1：有效，0：无效''',
    create_time datetime         null comment '创建时间',
    update_time datetime         null comment '更新时间'
)
    comment '图书馆用户组表';

INSERT INTO library.library_group (group_id, group_name, state, create_time, update_time) VALUES (1, '管理员', '1', '2023-02-19 00:00:00', '2023-02-19 00:00:00');
INSERT INTO library.library_group (group_id, group_name, state, create_time, update_time) VALUES (2, '普通用户', '1', '2023-02-19 00:00:00', '2023-02-19 00:00:00');

create table library.library_group_permission
(
    permission_id int auto_increment
        primary key,
    group_id      int         not null comment '用户组id',
    permission    varchar(16) not null comment '权限',
    create_time   datetime    null comment '创建时间',
    update_time   datetime    null comment '更新时间',
    constraint uniq_group_id_permission
        unique (group_id, permission)
)
    comment '用户组权限表';

INSERT INTO library.library_group_permission (permission_id, group_id, permission, create_time, update_time) VALUES (1, 1, 'book:add', null, null);
INSERT INTO library.library_group_permission (permission_id, group_id, permission, create_time, update_time) VALUES (2, 1, 'book:update', null, null);
INSERT INTO library.library_group_permission (permission_id, group_id, permission, create_time, update_time) VALUES (3, 1, 'book:query', null, null);
INSERT INTO library.library_group_permission (permission_id, group_id, permission, create_time, update_time) VALUES (4, 1, 'book:delete', null, null);
INSERT INTO library.library_group_permission (permission_id, group_id, permission, create_time, update_time) VALUES (5, 2, 'book:query', null, null);

create table library.library_user
(
    user_id       int auto_increment comment '用户id'
        primary key,
    user_name     varchar(16)      null comment '用户名称',
    user_password varchar(16)      null comment '用户密码',
    state         char default '1' null comment '用户状态，1：有效，0：无效',
    group_id      int              not null comment '用户组id',
    create_time   datetime         null comment '创建时间',
    update_time   datetime         null comment '修改时间',
    constraint uniq_user_name
        unique (user_name)
)
    comment '图书馆用户表';

INSERT INTO library.library_user (user_id, user_name, user_password, state, group_id, create_time, update_time) VALUES (1, 'admin', '123456', '1', 1, '2023-02-19 00:00:00', '2023-02-19 00:00:00');
INSERT INTO library.library_user (user_id, user_name, user_password, state, group_id, create_time, update_time) VALUES (2, 'user', '111111', '1', 2, null, null);
INSERT INTO library.library_user (user_id, user_name, user_password, state, group_id, create_time, update_time) VALUES (4, 'manager', '654321', '1', 1, null, null);
