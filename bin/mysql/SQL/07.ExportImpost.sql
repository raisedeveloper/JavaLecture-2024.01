###########################################################
#
# 데이터 조작 언어(DML : Data Manipulation Language)
#
############################################################

/* 
-- 1. secure_file_priv 확인
        C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\ - windows     - export 시 저장되는 공간
*/
SHOW VARIABLES LIKE 'secure_file_priv';

/*
-- 2. Export (Table -> File)        -TERMINATED 구분자
*/
SELECT * FROM song INTO OUTFILE 	
	'C:/programData/MySQL/MySQL Server 8.0/Uploads/song.csv'
	FIELDS TERMINATED BY ','
	ENCLOSED BY '"'
	LINES TERMINATED BY '\n';
	
/*
-- 3. Import (File -> Table)
*/
# 데이터 삭제
truncate song;

#데이터 로드
LOAD DATA INFILE
	'C:/programData/MySQL/MySQL Server 8.0/Uploads/song.csv'
	INTO TABLE song
	FIELDS TERMINATED BY ','
	ENCLOSED BY '"'
	LINES TERMINATED BY '\n';
SELECT * FROM song; // 출력


