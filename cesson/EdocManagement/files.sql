DROP DATABASE IF EXISTS files;
CREATE DATABASE files;

USE files;

DROP TABLE IF EXISTS edoc_category;
CREATE TABLE edoc_category(
id INT(4) PRIMARY KEY AUTO_INCREMENT COMMENT '分类编号',
`name` VARCHAR(20) NOT NULL COMMENT '分类名称'
)COMMENT='电子文档分类表';

INSERT INTO edoc_category(`name`)VALUES('java');
INSERT INTO edoc_category(`name`)VALUES('C#');
INSERT INTO edoc_category(`name`)VALUES('javaScript');


DROP TABLE IF EXISTS edoc_entry;
CREATE TABLE edoc_entry(
id INT(4) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
categoryId VARCHAR(20) NOT NULL COMMENT '分类编号',
title VARCHAR(50) NOT NULL COMMENT '文档名称',
summary VARCHAR(50) COMMENT '摘要',
uploaduser VARCHAR(50) COMMENT '上传人',
createdate DATETIME NOT NULL COMMENT '创建时间'
)COMMENT='电子文档条目';

INSERT INTO edoc_entry(categoryId,title,summary,uploaduser,createdate)VALUES(3,'javaScript学习笔记','javaScript学习笔记，最好的笔记','小兰','2012-01-21');
INSERT INTO edoc_entry(categoryId,title,summary,uploaduser,createdate)VALUES(1,'java面向编程','经典的java带你飞','陈诚','2013-1-1');
INSERT INTO edoc_entry(categoryId,title,summary,uploaduser,createdate)VALUES(2,'C#面向编程','多重窗体带你体验不一样的感觉','妤晨','2011-12-23');
SELECT *FROM edoc_category;
SELECT *FROM edoc_entry;