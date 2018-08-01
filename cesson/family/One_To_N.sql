DROP DATABASE IF EXISTS book;
CREATE DATABASE book;
USE book;

-- 图书表
DROP TABLE IF EXISTS bookFile;
CREATE TABLE bookFile(
id INT(4) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '一本书',
ISBN VARCHAR(50) NOT NULL COMMENT '版商一套书定的编号',
`name` VARCHAR(20) NOT NULL COMMENT '名称',
price FLOAT(20) NOT NULL COMMENT '价格',
discount FLOAT(20) NOT NULL COMMENT '折扣',
publisher VARCHAR(50) NOT NULL COMMENT '出版社'

)COMMENT='图书表' CHARSET=utf8;
SELECT *FROM bookFile;

INSERT  INTO `bookFile`(`ISBN`,`name`,`price`,`discount`,`publisher`) VALUES (123456789,'C#',28,8,'北大青鸟');
INSERT  INTO `bookFile`(`ISBN`,`name`,`price`,`discount`,`publisher`) VALUES (234567891,'java',28,8,'北大青鸟');
INSERT  INTO `bookFile`(`ISBN`,`name`,`price`,`discount`,`publisher`) VALUES (345678912,'html',28,8,'北大青鸟');

-- 作者表
DROP TABLE IF EXISTS person;
CREATE TABLE person(
person_id INT(4) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '编号',
person_name VARCHAR(20) NOT NULL COMMENT '名称'
)COMMENT='作者表' CHARSET=utf8;
SELECT *FROM person;

INSERT  INTO `person`(`person_name`) VALUES ('施耐庵');
INSERT  INTO `person`(`person_name`) VALUES ('吴承恩');
INSERT  INTO `person`(`person_name`) VALUES ('曹雪芹');

-- 作者表
DROP TABLE IF EXISTS three;
CREATE TABLE three(
three_id INT(4) PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '编号',
book_id INT(4) COMMENT '书籍Id',
person_id INT(4) COMMENT '作者Id' 
)COMMENT='第三方表' CHARSET=utf8;
SELECT *FROM three;

SELECT *FROM bookFile AS a INNER JOIN person AS b ON a.id =b.person_id INNER JOIN three AS c ON c.
