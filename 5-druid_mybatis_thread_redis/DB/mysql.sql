2020-11-10
        ---1-创建数据库
        create database if not exists lq;

        show DATABASES;
        ---2-创建表
        show TABLES from lq
        drop table  if exists lq.student ;
        CREATE TABLE lq.student (
        id     bigint not null auto_increment comment 'ID',
        num     varchar(9) DEFAULT NULL comment '学号',
        sname    varchar(20) DEFAULT NULL comment '姓名',
        sex     varchar(1) DEFAULT NULL comment '性别',
        age     varchar(6) DEFAULT NULL comment '年龄',
        PRIMARY KEY (id)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8

        ---3 表增加栏位
        ALTER TABLE lq.student
        ADD COLUMN `creTim` TIMESTAMP  NULL comment '创建时间';
