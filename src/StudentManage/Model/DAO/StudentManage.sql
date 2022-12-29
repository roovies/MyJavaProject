--==================================================================================================
-- # ���̺� ����
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
-- ## �������� �߰�
--==================================================================================================
--    * NOT NULL, CHECK, DEFAULT ���������� MODIFY�� �߰��ؾ� �Ѵ�.
-- 1. STUDENT_ID�� PK
ALTER TABLE STUDENT_TBL ADD CONSTRAINT STUDENT_PK PRIMARY KEY(STUDENT_ID);

-- 2. GENDER�� CHECK
ALTER TABLE STUDENT_TBL ADD CHECK(GENDER IN('M', 'F'));

-- 3. AGE, MEMBER_NAME, MEMBER_PWD�� NOT NULL
-- NOT NULL, CHECK, DEFAULT
ALTER TABLE STUDENT_TBL MODIFY AGE NOT NULL;
ALTER TABLE STUDENT_TBL MODIFY STUDENT_NAME NOT NULL;
ALTER TABLE STUDENT_TBL MODIFY STUDENT_PWD NOT NULL;


--==================================================================================================
-- ### ������ �߰� (ID, PWD, NAME, GENDER, AGE, EMAIL, PHONE, ADDR, HOBBY, ENROLLDATE)
--==================================================================================================
INSERT INTO STUDENT_TBL 
VALUES('admin', 'admin', '������', 'M', 30, 'admin@naver.com', '01012341234', '����� ������ ���ﵿ 15-3', '�ڵ�, ����, �', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('ilgaemi', 'gaemi12', '�ϰ���', 'M', 21, 'ilgaemi@naver.com', '01040886322', '����� ������ ������ 11-5', '�ڵ�, ����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('e_gaemi', 'roal25', '�̰���', 'M', 26, 'e_gaemi@naver.com', '01075169080', '����� ������ ���ﵿ 52-3', '�, ����, ����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('samgaemi', 'samsam1', '�ﰳ��', 'F', 22, 'samgaemi@naver.com', '01054660909', '����� ������ ������ 7-99', '����, ����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('4gaemi', 'tkroal123', '�簳��', 'M', 21, 'ilgaemi@naver.com', '01084436902', '����� �߱� �� 833-5', '�ڵ�, �, ����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('o_gaemi', 'gaemi12', '������', 'F', 22, 'o_gaemi@naver.com', '01083481546', '����� ������ ������ 22-50', '����, �, ����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('yukgaemi', 'dbrro33', '������', 'M', 27, 'ilgaemi@naver.com', '01060997522', '����� ������ ���ﵿ 6-2', '����, �, ����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('chillant', 'hiphop12', 'ĥ����', 'F', 26, 'chilgaemi@naver.com', '01042331050', '����� ������ ������ 6-10', '�, ����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('palgaemi', 'gaemi88', '�Ȱ���', 'M', 23, 'palgaemi@naver.com', '01054449999', '����� �߱� ȸ���� 44-5', '����, �ڵ�', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('9gaemi', 'gaemi12', '������', 'M', 23, '99gaemi@naver.com', '01052116060', '����� �߱� ȸ���� 60-53', '����, ����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('ilggun', 'ggun11', '�ϲ�', 'M', 22, 'ilggun@naver.com', '01026448090', '��⵵ ���� �ϻ굿 999', '����, �ڵ�, �', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('2ggun', 'rnsrns1', '�̲�', 'F', 21, '2ggun@naver.com', '01072224444', '��⵵ ���� �ϻ굿 15-666', '�ڵ�, �, ����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('samggun', 'ggun33', '���', 'M', 26, 'sam@naver.com', '01090603452', '��⵵ �Ȼ�� ��ϵ� 8-90', '�, ����, ����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('saggun', 'sasaa11', '���', 'M', 24, 'sag@naver.com', '01071254609', '��⵵ �Ȼ�� ��ϵ� 25-4', '����', DEFAULT);
INSERT INTO STUDENT_TBL 
VALUES('o_ggun', 'onaee3', '����', 'F', 20, 'o_ggun@naver.com', '01023153060', '��⵵ ���� ź���� 777', '�, ����', DEFAULT);


SELECT * FROM STUDENT_TBL;
COMMIT; --Ŀ�ԿϷ� Ŀ���� ����� �ڹٿ��� ����ȭ��