
################################################################
#
# 데이터 정의 언어 (DDL: Data Definition Language)
#
################################################################

-- 1. 테이블 생성 
-- ERMaster 활용
# 주소록 테이블 생성

CREATE TABLE addrBook (
	aid int NOT NULL AUTO_INCREMENT,
	name varchar(16) NOT NULL,
	tel varcha
    r(16),
	email varchar(32),
	birthDay datetime NOT NULL,
	PRIMARY KEY (aid)
);

# 사용자 테이블 생성
CREATE TABLE users (
	uid varchar(12) NOT NULL,
	pwd char(60) NOT NULL,
	uname varchar(16) NOT NULL,
	email varchar(32),
	regDate date DEFAULT (CURRENT_DATE),
	isDeleted int DEFAULT 0,
	PRIMARY KEY (uid)
);

DESC addrBook;      // 

-- 2. 
-- 테이블 목록 확인 - 데이터베이스내의 테이블 목록
SHOW TABLE;

-- 테이블 구조
DESC users;         # describe

-- 3. 테이블 삭제
# largeCity view 삭제
DROP view largeCity;

# dateTable 삭제
DROP TABLE dateTable;       // 이거 하고
SHOW TABLES;                // 이거 누르면 없어진 거 확인 가능 ㅇㅇ

# kcity 테이블의 모든 데이터 삭제
truncate kcity;

/*
 * 4. 테이블 이름 변경
 */
RENAME TABLE kcity TO korCity;

/*
 * 5. 테이블 구조 변경
 */
#users 테이블에서 email 뒤에 tel 추가
ALTER talble users;
ADD tel VARCHAR(16) NOT NULL AFTER email;
DESC users;

# users 테이블에서 tel 필드의 not null 제거
ALTER talble users
    CHANGE tel tel VARCHAR(16);     // 바꾸기 전에는 NULL 이었는데 바꾼 후는 YES 가 됨