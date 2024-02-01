###########################################################
#
# 데이터 조작 언어(DML : Data Manipulation Language)
#
############################################################

SHOW DATABASES;
USE WORLD;
SHOW TABLES;
DESC city;

/*
* 1. Select
*/
/*
SELECT 필드명
    FROM 테이블명
    JOIN 테이블명
    ON 조인 조건
    WHERE 조회 조건
    GROUP BY 필드명
    HAVING 그룹 조건
    ORDER BY 필드명 순서
    LIMIT 숫자 OFFSET 숫자;
*/

SELECT * FROM city;         // SELECT 뒤에 * 을 달면 전체 다 가지고 오는 것임
SELECT 'name' , population FROM city LIMIT 10;  #필드명을 보존하고 싶을 때 'back quote' 사용

/*
* 1-1. 조회 조건: where
*/
SELECT * FROM city WHERE countrycode='KOR';
SELECT * FROM city WHERE population >= 9000000;
SELECT * FROM city WHERE countrycode='KOR' AND population >= 1000000;
SELECT DISTINCT district FROM city WHERE coutrycode='KOR'; # DISTINCT 중복 제거(고유한 값)

# 수도권 도시(서울, 인천, 경기)
SELECT * FROM city
        WHERE district = 'Seoul' OR district = 'Inchon' OR district = 'kyonggi';
SELECT * FROM city
        WHERE district IN ('Seoul', 'Inchon', 'Kyonggi');

# 경기도에서 인구수가 홀수인 도시
SELECT * FROM city WHERE district = 'Kyonggi' AND population % 2 = 1;

# 국내에서 인구수가 50 ~ 100 만인 도시
SELECT * FROM city WHERE countrycode='KOR' AND 
    population >= 500000 AND population <= 1000000;
SELECT * FROM city WHERE countrycode='KOR' AND 
    population between 500000 AND 1000000;

# 충청남북도의 도시
SELECT * FROM city WHERE district IN ('Chungchongbuk', 'Chungchongnam');
SELECT * FROM city WHERE district LIKE 'Chungchong%'        // 임의의 문자, 이때는 LIKE 사용

/*
*  1-2. 순서(Order) : ASC(Ascending: 오름차순, default), DESC(Descending: 내림차순)
*/
# 인구수가 900만 이상인 도시를 인구수의 내림차순으로 조회
SELECT * FROM city WHERE population >= 9000000
    ORDER BY population DESC;

# 국내에서 인구수가 50~100만인 도시를 지역 오름차순, 인구수 내림차순으로 조회
SELECT * FROM city WHERE countrycode='KOR'
    AND population >= 500000 AND population <= 1000000
   ORDER BY district ASC, population DESC;

# 국내에서 인구수가 50~100만인 도시를 지역, 인구수 내림차순으로 조회
SELECT * FROM city WHERE countrycode='KOR'
    AND population >= 500000 AND population <= 1000000
   ORDER BY district, population DESC;

/*
*  1-3. 갯수 
*/
# 전세계에서 인구수 top 10
SELECT * FROM city ORDER BY population DESC LIMIT 10;

# 국내 인구수 top 5
SELECT * FROM city WHERE countrycode='KOR' ORDER BY population DESC LIMIT 5;

SELECT * FROM city WHERE countrycode='KOR'
    ORDER BY population DESC LIMIT

/*
* 1.4 함수
*/+-
# 현재 날짜와 시각
SELECT now();       # 2024-02-01 13 :44:48

# 국내 도시의 객수 - 레코드의 갯수
SELECT count(*) FROM city WHERE countrycode = 'KOR';

# 최대, 최소 - 국내 도시중 인구수 최대 최소 도시
SELECT MAX(population), MIN(population) FROM city WHERE countrycode='KOR';

# 국내 도시의 인구 평균
SELECT ROUND (AVG(population)) AS avgPop From city      # AS 생략가능
    WHERE countrycode='KOR';
    SELECT count(*) numCity FROM city WHERE countrycode'KOR';

/*
* 1.5 그룹핑
*/
# 국내 광역시도별 인구수의 평균을 내림차순으로 조회하기
SELECT district, ROUND(AVG(population)) avgPop FROM city 
    WHERE countrycode='KOR'
    GROUP BY district
    ORDER BY avgPop DESC;

# 도시의 갯수가 많은 나라 Top 10
SELECT countrycode, count(*) numCity FROM city
    GROUP BY countrycode
    ORDER BY numCity DESC
    LIMIT 10;

# 충청남도의 도시 이름
SELECT `name` FROM city WHERE district='Chungchongnam'
SELECT GROUP_CONCAT(`name`) cities FROM city WHERE countrycode='Chungchongnam';

# 국내 광역시도 이름
SELECT DISTINCT district FROM city WHERE countrycode='KOR';
SELECT GROUP_CONCAT(district) districts FROM city WHERE countrycode='KOR';

/*
* 1.6 그룹핑 조건
*/

# 국내 도별(도시의 객수가 2개 이상) 인구수의 평균을 내림차순으로 조회하기
SELECT district, ROUND(AVG(population)) avgPop FROM city 
                 WHERE coutrycode='KOR'
                 GROUP BY district
    # 조건주기   HAVING count(*) >= 2      # 그룹핑 조건 - 도시의 갯수가 2개 이상
                 ORDER BY avgPop DESC;

# 국내 도시의 갯수가 5개 이상인 도 검색하기
SELECT district, count(*) numCity FROM city
    WHERE countrycode='KOR'
    GROUP BY district
    Having numCity >= 5;

# 국내 도시의 갯수가 5개 이상인 도의 평균 도시 인구수 구하(고&) 인구 평균 내림차순으로 정렬하기
SELECT district, ROUND(AVG(population)) avgPop FROM city 
    WHERE countrycode='KOR'
        GROUP BY district
            Having count(*) >= 5
        ORDER BY avgPop DESC;

# 도시 갯수가 100개 이상인 국가의 도시 인구 평균을 내림차순으로 정렬하기
SELECT countrycode, ROUND(AVG(population)) avgPop FROM city
GROUP BY countrycode
Having count(*) >= 100
 ORDER BY avgPop DESC;