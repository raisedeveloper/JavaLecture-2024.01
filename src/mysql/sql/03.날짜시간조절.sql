################################################################
#
# Date / Time - 날짜/시간 조작
#
################################################################

/*
1. 테이블 생성
*/

create TABLE of not exists dataTable (
    id int primary key auto_increment, 
    regDate DATE default (current_date),
    modTime datetime default current_timestamp
);

/*
2. 데이터 입력
*/
INSERT into dataTable values (default, default, default)
INSERT into dataTable(id) values (default)
INSERT into dataTable(regDate, modTime) 
    values ('2024-01-01', '2024-01-31 10:25:00'), ('2024-02-01', '2024-02-02 10:45:00')

/*
 * 3. 데이터 조회
 */
# 2024-02-02 형식
SELECT regDate, DATE_FORMAT(modTime, '%Y-%m-%d') FROM dateTable;

# 10:45:00 AM 형식
SELECT DATE_FORMAT(modTime, '%h:%i:%s %p') FROM dateTable;

# 24-02-02 16:45 형식
SELECT DATE_FORMAT(modTime, '%y-%m-%d %H:%i') FROM dateTable;

# 날짜 조회 함수
SELECT NOW(), CURDATE(), CURTIME();

/*
-- 4. 날짜 수정
*/
UPDATE datetable SET regdate=CURDATE(), modtime=NOW() WHERE id=3;

/*
-- 5. 날짜 계산 _ 날짜 더하기 빼기
*/
SELECT DATE_ADD(NOW(), INTERVAL 40 DAY);        // 2024-03-13 11:11:47 - 40일 후
SELECT DATE_ADD(NOW(), INTERVAL 3 month);       // 2024-05-02 11:12:24 _ 3개월 더함
SELECT DATE_SUB(CURDATE(), INTERVAL 3 month);   // 2023-11-02 _ 3개월 뺌

-- d-day 계산
SELECT TO_DAYS('2024-11-14') - TO_DAYS(CURDATE());      // D- 286 일 남음 (24년 수능일)

-- 요일: 1 - 일요일
SELECT DAYOFWEEK(regDate) FROM datetable;

-- Memorize It!
-- 테이블은 실체가 있고 뷰는 실체가 없다 
-- 그래서 테이블에 업데이트를 해야하고 뷰에 하면 안됨
-- 뷰는 단순 조회용이다
CREATE VIEW largeCity AS SELECT * FROM city
WHERE population>8000000;
