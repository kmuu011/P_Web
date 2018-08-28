
/* Drop Triggers */

DROP TRIGGER TRI_Depart_info_diNum;
DROP TRIGGER TRI_Level_info_liNum;
DROP TRIGGER TRI_Member_info_miNum;



/* Drop Tables */

DROP TABLE Member_info CASCADE CONSTRAINTS;
DROP TABLE Depart_info CASCADE CONSTRAINTS;
DROP TABLE Level_info CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_Depart_info_diNum;
DROP SEQUENCE SEQ_Level_info_liNum;
DROP SEQUENCE SEQ_Member_info_miNum;




/* Create Sequences */

CREATE SEQUENCE SEQ_Depart_info_diNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Level_info_liNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Member_info_miNum INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE Depart_info
(
	-- 부서번호
	diNum number(10,0) NOT NULL,
	-- 부서코드
	diCode char(6) NOT NULL UNIQUE,
	-- 부서명
	diName varchar2(100) NOT NULL,
	-- 부서설명
	diDesc varchar2(1000),
	PRIMARY KEY (diNum)
);


CREATE TABLE Level_info
(
	liNum number(10,0) NOT NULL,
	-- 실제레벨
	liLevel number(2,0) DEFAULT 1 NOT NULL UNIQUE,
	liName varchar2(30) NOT NULL UNIQUE,
	-- 레벨 권한 설명
	liDesc varchar2(300),
	PRIMARY KEY (liNum)
);


CREATE TABLE Member_info
(
	miNum number(10,0) NOT NULL,
	miId varchar2(100) NOT NULL UNIQUE,
	miName varchar2(100) NOT NULL,
	-- SHA256 암호화로직 추가예정
	miPwd varchar2(100) NOT NULL,
	-- Depart_info테이블의 부서 코드
	diCode char(6) NOT NULL,
	-- Level_info테이블의 레벨번호
	liLevel number(2,0) DEFAULT 1 NOT NULL UNIQUE,
	miEmail varchar2(200) NOT NULL,
	miDesc varchar2(3000),
	miPhone char(20),
	miZipCode char(6),
	miAddress1 varchar2(150),
	miAddress2 varchar2(100),
	PRIMARY KEY (miNum)
);



/* Create Foreign Keys */

ALTER TABLE Member_info
	ADD FOREIGN KEY (diCode)
	REFERENCES Depart_info (diCode)
;


ALTER TABLE Member_info
	ADD FOREIGN KEY (liLevel)
	REFERENCES Level_info (liLevel)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_Depart_info_diNum BEFORE INSERT ON Depart_info
FOR EACH ROW
BEGIN
	SELECT SEQ_Depart_info_diNum.nextval
	INTO :new.diNum
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Level_info_liNum BEFORE INSERT ON Level_info
FOR EACH ROW
BEGIN
	SELECT SEQ_Level_info_liNum.nextval
	INTO :new.liNum
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Member_info_miNum BEFORE INSERT ON Member_info
FOR EACH ROW
BEGIN
	SELECT SEQ_Member_info_miNum.nextval
	INTO :new.miNum
	FROM dual;
END;

/




/* Comments */

COMMENT ON COLUMN Depart_info.diNum IS '부서번호';
COMMENT ON COLUMN Depart_info.diCode IS '부서코드';
COMMENT ON COLUMN Depart_info.diName IS '부서명';
COMMENT ON COLUMN Depart_info.diDesc IS '부서설명';
COMMENT ON COLUMN Level_info.liLevel IS '실제레벨';
COMMENT ON COLUMN Level_info.liDesc IS '레벨 권한 설명';
COMMENT ON COLUMN Member_info.miPwd IS 'SHA256 암호화로직 추가예정';
COMMENT ON COLUMN Member_info.diCode IS 'Depart_info테이블의 부서 코드';
COMMENT ON COLUMN Member_info.liLevel IS 'Level_info테이블의 레벨번호';



