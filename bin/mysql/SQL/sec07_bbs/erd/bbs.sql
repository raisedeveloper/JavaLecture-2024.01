create database if not exists bbs;
use bbs;

SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS NEW_TABLE;
DROP TABLE IF EXISTS users;




/* Create Tables */

CREATE TABLE NEW_TABLE
(
	bid int NOT NULL AUTO_INCREMENT,
	title varchar(256) NOT NULL,
	content varchar(4000),
	uid varchar(12) NOT NULL,
	modTime datetime DEFAULT CURRENT_TIMESTAMP,
	isDeleted int DEFAULT 0,
	viewCount int DEFAULT 0,
	replyCount int DEFAULT 0,
	PRIMARY KEY (bid)
);


CREATE TABLE reply
(
	rid int NOT NULL,
	comment varchar(256) NOT NULL,
	regTime datetime DEFAULT CURRENT_TIMESTAMP,
	uid varchar(12) NOT NULL,
	bid int NOT NULL
);


CREATE TABLE users
(
	uid varchar(12) NOT NULL,
	pwd char(60) NOT NULL,
	uname varchar(16) NOT NULL,
	email varchar(32),
	regDate date DEFAULT (CURRENT_DATE),
	isDeleted int DEFAULT 0,
	PRIMARY KEY (uid)
);



/* Create Foreign Keys */		/*유저 만들고 보드 만들어야 함 : 사용자가 없으면 보드에 입력X */
								/* FOREIGN키에 없는 것은 입력X */
ALTER TABLE reply
	ADD FOREIGN KEY (bid)		 
	REFERENCES NEW_TABLE (bid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE NEW_TABLE
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE reply
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid) /* users (uid) : USER table을 참조하는 users가 만들어짐 */
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



