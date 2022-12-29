--==================================================================================================
-- # 테이블 생성
--==================================================================================================
CREATE TABLE STUDENT_TBL(
    STUDENT_ID VARCHAR2(15),
    STUDENT_PWD VARCHAR2(15),
    STUDENT_NAME VARCHAR2(20),
    GENDER CHAR(1),
    AGE NUMBER,
    EMAIL VARCHAR2(30),
    PHONE CHAR(11),
    ADDRESS VARCHAR2(500),
    HOBBY VARCHAR2(50),
    ENROLL_DATE DATE DEFAULT SYSDATE
);


--==================================================================================================
-- ## 제약조건 추가
--==================================================================================================
--    * NOT NULL, CHECK, DEFAULT 제약조건은 MODIFY로 추가해야 한다.
-- 1. STUDENT_ID에 PK
ALTER TABLE STUDENT_TBL ADD CONSTRAINT STUDENT_PK PRIMARY KEY(STUDENT_ID);

-- 2. GENDER에 CHECK
ALTER TABLE STUDENT_TBL ADD CHECK(GENDER IN('M', 'F'));

-- 3. AGE, MEMBER_NAME, MEMBER_PWD에 NOT NULL
-- NOT NULL, CHECK, DEFAULT
ALTER TABLE STUDENT_TBL MODIFY AGE NOT NULL;
ALTER TABLE STUDENT_TBL MODIFY STUDENT_NAME NOT NULL;
ALTER TABLE STUDENT_TBL MODIFY STUDENT_PWD NOT NULL;


--==================================================================================================
-- ### 데이터 추가 (ID, PWD, NAME, GENDER, AGE, EMAIL, PHONE, ADDR, HOBBY, ENROLLDATE)
--==================================================================================================
INSERT INTO STUDENT_TBL 
VALUES('admin', 'admin', '관리자', 'M', 30, 'admin@naver.com', '01012341234', '서울시 강남구 역삼동 15-3', '코딩, 독서, 운동', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('ilgaemi', 'gaemi12', '일개미', 'M', 21, 'ilgaemi@naver.com', '01040886322', '서울시 마포구 공덕동 11-5', '코딩, 쇼핑', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('e_gaemi', 'roal25', '이개미', 'M', 26, 'e_gaemi@naver.com', '01075169080', '서울시 마포구 대흥동 52-3', '운동, 게임, 쇼핑', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('samgaemi', 'samsam1', '삼개미', 'F', 22, 'samgaemi@naver.com', '01054660909', '서울시 강남구 논현동 7-99', '독서, 쇼핑', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('4gaemi', 'tkroal123', '사개미', 'M', 21, 'ilgaemi@naver.com', '01084436902', '서울시 중구 명동 833-5', '코딩, 운동, 쇼핑', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('o_gaemi', 'gaemi12', '오개미', 'F', 22, 'o_gaemi@naver.com', '01083481546', '서울시 마포구 공덕동 22-50', '독서, 운동, 게임', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('yukgaemi', 'dbrro33', '육개미', 'M', 27, 'ilgaemi@naver.com', '01060997522', '서울시 강남구 역삼동 6-2', '독서, 운동, 쇼핑', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('chillant', 'hiphop12', '칠개미', 'F', 26, 'chilgaemi@naver.com', '01042331050', '서울시 강남구 논현동 6-10', '운동, 쇼핑', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('palgaemi', 'gaemi88', '팔개미', 'M', 23, 'palgaemi@naver.com', '01054449999', '서울시 중구 회현동 44-5', '게임, 코딩', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('9gaemi', 'gaemi12', '구개미', 'M', 23, '99gaemi@naver.com', '01052116060', '서울시 중구 회현동 60-53', '독서, 쇼핑', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('ilggun', 'ggun11', '일꾼', 'M', 22, 'ilggun@naver.com', '01026448090', '경기도 고양시 일산동 999', '독서, 코딩, 운동', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('2ggun', 'rnsrns1', '이꾼', 'F', 21, '2ggun@naver.com', '01072224444', '경기도 고양시 일산동 15-666', '코딩, 운동, 독서', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('samggun', 'ggun33', '삼꾼', 'M', 26, 'sam@naver.com', '01090603452', '경기도 안산시 상록동 8-90', '운동, 게임, 쇼핑', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('saggun', 'sasaa11', '사꾼', 'M', 24, 'sag@naver.com', '01071254609', '경기도 안산시 상록동 25-4', '게임', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('o_ggun', 'onaee3', '오꾼', 'F', 20, 'o_ggun@naver.com', '01023153060', '경기도 고양시 탄현동 777', '운동, 독서', DEFAULT);


SELECT * FROM STUDENT_TBL;
COMMIT; --커밋완료 커밋을 해줘야 자바에서 동기화됨