###########################################################
#
# 데이터 조작 언어(DML : Data Manipulation Language)
#
############################################################

/*
    2. UPDATE

    UPDATE 테이블
    SET 필드명1=값1, 필드명2=값2, ..., 필드명n=값n
    WHERE 조건;                     # 조건 - 프라이머리 키 = 값
*/

UPDATE kcity SET name='수원', population=1200000 WHERE id=2340;
UPDATE kcity SET name='용인', population=1200000 WHERE id=2362
- ID가 2391 이상인 도시의 인구를 10만 추가
UPDATE kcity SET  population=population+1000000 WHERE id>2390;

/*
 3. INSERT
    INSERT INTO 테이블(필드명1, 필드명2, ..., 필드명n)
0
*/
# 경기도 화성시 의정부시 
INSERT INTO kcity
    VALUES (default, '화성', 'KOR', 'Kyonggi', 900000)
    VALUES (default, '의정부', 'KOR', 'Kyonggi', 200000)

# 강원도 속초시 추가 - default VALUE 활용(auto_increment 포함)
INSERT INTO kcity(name, countrycode, district) VALUES('속초', 'KOR','Kang-won');
// 자동 생성으로 설정된 것이 아이디밖에 없음 - 인구설정이 안되어 있어서 자동 추가 안됨 default=0

# 경기도 광주시 추가 - default VALUE 활용(auto_increment 포함)
INSERT INTO kcity VALUES(2600, '광주', 'KOR','Kyonggi', '300000'); // 지정해서 30만이 자동으로 들어감