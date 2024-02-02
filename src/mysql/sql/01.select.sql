#####################################################
#
# 데이터 조작 언어(DML : Data Manipulation Language)
#
#####################################################

SHOW DATABASE
USE world;
SHOW world;
DESC city;

-- 1.1 Select        키워드는 대문자로 시작함. 

-- SELECT 필드명
-- FROM    테이블명
-- JOIN    테이블명
-- ON       조인 조건
-- WHERE    조회 조건
-- GROUP BY  필드명
-- HAVING   그룹 조건
-- ORDER BY 필드명 순서
-- LIMIT 숫자 OFFSET 숫자;

-- 다 써도 되고 이 중 일부만 써도 됨

SELECT * FROM city;
SELECT NAME, population FROM city;
SELECT NAME, countrycode FROM city;
SELECT NAME FROM city LIMIT 10;
SELECT `name`, population FROM city LIMIT 10;           -- ``(back quote) 안에 쓰면 필드명 보존 가능

SELECT * FROM city WHERE countrycode='KOR';
SELECT * FROM city WHERE population >= 9000000;
SELECT * FROM city WHERE countrycode='KOR' and population >= 1000000;
SELECT DISTINCT district FROM city WHERE countrycode='KOR';     -- DISTINCT : 고유한 값을 보여줌

# 수도권 도시 (서울, 인천, 경기)
SELECT * FROM city                          -- * (as the list) : 모든 필드
	WHERE district='Seoul' or district='Inchon' or district='Kyonggi';

SELECT * FROM city WHERE district IN ('Seoul', 'Inchon', 'Kyonggi');

# 경기도에서 인구수가 홀수인 도시
SELECT * FROM city WHERE district='Kyonggi' AND population % 2 = 1;

# 국내에서 인구수가 50~100만인 도시
SELECT * FROM city WHERE countrycode='KOR' AND
    population > 500000 AND population <= 1000000;

SELECT * FROM city WHERE countrycode='KOR' AND population between 500000 AND 1000000;

# 충청남북도의 도시
SELECT * FROM city 
    WHERE district='Chungchongbuk' or district='Chungchongnam';

SELECT * FROM city 
    WHERE district LIKE 'Chungchong%';        -- % : (wildcard) 임의의 문자, 이때는 Like 사용.
                                              -- Chungchong이 들어간 모든 도시 반환



-- 1.2 순서(Order) - ASC(Ascending: 오름차순, default) / DESC(Descending: 내림차순)

# 인구수가 9백만 이상인 도시를 내림차순으로 조회
SELECT * FROM city WHERE population >= 9000000
    ORDER BY population DESC;

# 국내에서 인구수가 50~100만인 도시를 지역 오름차순, 인구수 내림차순으로 조회
SELECT * FROM city WHERE countrycode='KOR' AND population between 500000 AND 1000000
    ORDER BY district ASC, population DESC;     -- ASC는 사실 생략해도 됨. default기 때문에


-- 1.3 갯수

# 전세계 인구수 상위 10개 도시 조회
SELECT * FROM city ORDER BY population DESC LIMIT 10;

# 국내 인구수 상위 5개 도시 조회        -- 키워드 입력 순서에 유의할 것; FROM - WHERE - ORDER BY - LIMIT 순
SELECT * FROM city WHERE countrycode='KOR' ORDER BY population DESC LIMIT 5;

# 국내 인구수 상위 11~20위 도시 조회
SELECT * FROM city WHERE countrycode='KOR' ORDER BY population DESC LIMIT 10 OFFSET 10;
                                                            -- OFFSET(건너뜀) 앞에서 10개를 건너뛰고 10개 보여줌


-- 1.4 함수

# 현재 날짜와 시각
SELECT now();

# 국내 도시의 갯수 - 레코드의 갯수
SELECT count(*) FROM city WHERE countrycode='KOR';

# 최대, 최소 - 국내 도시 중 인구수 최대, 최소 도시
SELECT MAX(population), MIN(population) FROM city WHERE countrycode='KOR';

# 국내 도시의 인구 평균
SELECT AVG(population) FROM city WHERE countrycode='KOR';           -- 소수점 이하까지 다 나옴
SELECT ROUND(AVG(population)) FROM city WHERE countrycode='KOR';    -- 소수점 이하 제외

# 변수 이름을 변경하고 싶다 (Aliasing)
SELECT ROUND(AVG(population)) AS avgPop FROM city WHERE countrycode='KOR';  -- AS 변경할이름 (AS는 생략 가능)

SELECT count(*) numCity FROM city WHERE countrycode='KOR';

-- DTO명과 SELECT 대상의 이름이 같으면 자동으로 바꿔줌 (뭐슬..? 보충할 것)



-- 1.5 그룹핑(Grouping)

# 국내 광역시도별 인구수 평균을 내림차순으로 조회
SELECT district, ROUND(AVG(population)) avgPop FROM city
    WHERE countrycode='KOR'
    GROUP BY district
    ORDER BY avgPop DESC;


# 도시의 갯수가 많은 나라 상위 10개국
SELECT countrycode, count(*) numCity FROM city
    GROUP BY countrycode
    ORDER BY numCity DESC
    LIMIT 10;


# 경기도의 도시 이름
SELECT `name` FROM city WHERE district='Kyonggi';       -- 줄바꿈 되어 나열됨
SELECT GROUP_CONCAT(`name`) cities FROM city WHERE district='Kyonggi';      -- 한줄에 이어서 줄바꿈 없이 나열됨

SELECT GROUP_CONCAT(`name`) cities FROM city WHERE district='Chungchongnam';

# 국내 광역시도 이름
SELECT DISTINCT district FROM city WHERE countrycode='KOR';
SELECT GROUP_CONCAT(district) districts FROM city WHERE countrycode='KOR';


-- 1.6 그룹핑 조건

# 국내 도별(도시 갯수가 2개 이상) 인구수의 평균을 내림차순으로 조회
SELECT district, ROUND(AVG(population)) avgPop FROM city
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING count(*) >= 2
    ORDER BY avgPop DESC;

# 국내에서 도시 갯수가 5개 이상인 도
SELECT district, count(*) numCity FROM city 
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING numCity >= 5;

# 국내에서 도시 갯수가 5개 이상인 도의 평균 도시 인구수를 인구 평균 내림차순으로 정렬
SELECT district, ROUND(AVG(population)) avgPop FROM city
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING count(*) >= 5
    ORDER BY avgPop DESC;

# 도시 갯수가 100개 이상인 국가의 도시인구 평균을 내림차순으로 정렬
SELECT countrycode, ROUND(AVG(population)) avgPop FROM city
GROUP BY countrycode
HAVING count(*) >= 100
ORDER BY avgPop DESC;


-- 1.7 Join

# 인구수가 800만보다 큰 도시의 국가명, 도시명, 인구수
SELECT country.Name, city.Name, city.population FROM city
    JOIN country ON city.countrycode=country.Code
    WHERE city.population > 8000000;

SELECT r.NAME countryName, l.Name cityName, l.Population FROM city l
INNER JOIN country r                -- INNER는 생략 가능
ON l.countrycode=r.Code
WHERE l.Population > 8000000;

# 양쪽 테이블에서 필드명이 고유한 필드는 테이블 이름 생략 가능함 (Continent)
SELECT Continent, r.Name countryName, l.Name cityName, l.Population FROM city l
	INNER JOIN country r
	ON l.countrycode=r.Code
	WHERE l.Population > 8000000;

# 아시아 대륙에서 인구수가 많은 도시 상위 10개국
SELECT Continent, r.Name countryName, l.Name cityName, l.Population FROM city l
    JOIN country r
    ON l.CountryCode=r.Code
    WHERE r.Continent='Asia'
    ORDER BY l.Population DESC
    LIMIT 10;

# 인도에서 사용되는 언어
SELECT * FROM countrylanguage WHERE countrycode='IND';

# 아시아 국가의 사용 언어
SELECT l.Name, r.`language` FROM country l 
JOIN countrylanguage r
ON l.Code=r.CountryCode
WHERE l.Continent='Asia' AND r.IsOfficial='T';


-- 3개 테이블 조인
# 아시아 대륙에서 인구수가 가장 많은 상위 10개 도시에서 사용하는 공식 언어
SELECT r.Name countryName, l.Name cityName, o.`language` FROM city l
JOIN country r ON l.CountryCode=r.Code
JOIN countrylanguage o ON l.CountryCode=o.CountryCode
WHERE l.Continent='Asia' AND r.IsOfficial='T'
ORDER BY l.Population DESC
LIMIT 10;

/*
*  1-8. Sub Query
*/
# 국내 도시만으로 새로운 테이블을 만드는 경우
create TABLE if not exists kcity like city; # city를 기반으로 형식만 맞춰서 복사해옴, 값은 아직 없음
INSERT INTO kcity
    SELECT * FROM city WHERE countrycode = "KOR"
    AND id NOT IN (SELECT id FROM kcity); 
    // 한국에 있는 도시만 데이터를 복사해서 kcity 테이블에 추가, 오류가 뜨지만 테이블은 잘 생성