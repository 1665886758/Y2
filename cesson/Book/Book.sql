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
INSERT INTO three(book_id,person_id)VALUES(2,2);
INSERT INTO three(book_id,person_id)VALUES(1,3);
INSERT INTO three(book_id,person_id)VALUES(3,2);

 SELECT b1.id,b1.name,p1.person_name FROM three AS t1 INNER JOIN bookFile AS b1 ON t1.book_id=b1.id INNER JOIN person AS p1 ON p1.person_id=t1.person_id WHERE p1.person_id=2
SELECT b1.id,b1.name,p1.person_namehusband_wife FROM three AS t1 INNER JOIN bookFile AS b1 ON t1.book_id=b1.id INNER JOIN person AS p1 ON p1.person_id=t1.person_id WHERE b1.id=2 OR b1.id=
