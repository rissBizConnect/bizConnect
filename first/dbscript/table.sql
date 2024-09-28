DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE NOTICE CASCADE CONSTRAINTS;
DROP TABLE BOARD CASCADE CONSTRAINTS;

-- �Ҽȷα��ν� ȸ�������� �̿��� ����� ȸ�� ���̺�
CREATE TABLE MEMBER(
  USERID VARCHAR2(50) CONSTRAINT PK_MEMBER_UID PRIMARY KEY,
  USERPWD VARCHAR2(100),
  USERNAME VARCHAR2(20) NOT NULL,
  GENDER CHAR(1)  NOT NULL,
  AGE NUMBER(3)   NOT NULL,
  PHONE VARCHAR2(13),
  EMAIL VARCHAR2(30) not null,  
  ENROLL_DATE DATE DEFAULT SYSDATE,
  LASTMODIFIED DATE DEFAULT SYSDATE,
  signtype VARCHAR2(10) default 'direct' not null,
  -- ���Թ�� : ���� ����('direct'), �Ҽȷα���('kakao', 'naver', 'google') 
  ADMIN_YN CHAR(1) DEFAULT 'N' not null,
  login_ok CHAR(1) DEFAULT 'Y' not null,
  photo_filename  varchar2(100)
  );

comment on column member.userid is 'ȸ�����̵�';
comment on column member.userpwd is 'ȸ���н�����';
comment on column member.username is 'ȸ���̸�';
comment on column member.gender is 'ȸ������';
comment on column member.age is 'ȸ������';
comment on column member.email is 'ȸ���̸���';
comment on column member.phone is 'ȸ����ȭ��ȣ';
comment on column member.enroll_date is 'ȸ�����Գ�¥';
comment on column member.userid is 'ȸ�����̵�';
comment on column member.lastmodified is '������������¥';
comment on column member.signtype is '���Թ��';
comment on column member.login_ok is '�α��ΰ��ɿ���';
comment on column member.admin_yn is '�����ڿ���';
comment on column member.photo_filename is 'ȸ���������ϸ�';

CREATE TABLE USERS (
  USERID VARCHAR2(15) PRIMARY KEY,
  USERPWD VARCHAR2(100) NOT NULL,
  USERNAME VARCHAR2(20) NOT NULL
);

ALTER TABLE USERS
DROP PRIMARY KEY;

-- �������� �߰��� �� �������� �߰���
ALTER TABLE USERS
ADD CONSTRAINT FK_MEMBER_UID 
FOREIGN KEY(USERID) REFERENCES MEMBER ON DELETE CASCADE;

-- TRIGGER �ۼ� : �̸� - TRI_INSERT_USERS
-- MEMBER ���̺� �� ȸ�������� ��ϵǸ�, �ڵ����� USERS ���̺� ���̵�, ��ȣ, �̸���
-- INSERT �ǰ� ��
CREATE OR REPLACE TRIGGER TRI_INSERT_USERS
AFTER INSERT ON MEMBER
FOR EACH ROW
BEGIN
  INSERT INTO USERS
  VALUES (:NEW.USERID, :NEW.USERPWD, :NEW.USERNAME);
END;
/

CREATE OR REPLACE TRIGGER TRI_UPDATE_USERS
AFTER UPDATE ON MEMBER
FOR EACH ROW
BEGIN
  UPDATE USERS 
  SET USERPWD = :NEW.USERPWD
  WHERE USERID = :OLD.USERID;
END;
/

INSERT INTO MEMBER VALUES ('admin', 'admin', '������', 'M', 35, '010-1111-9999', 
'admin@ncs.kr', to_date('2016-06-25', 'RRRR-MM-DD'), sysdate, default, 'Y', default, null);

INSERT INTO MEMBER
VALUES ('user01', 'pass01', 'ȫ�浿', 'M', 25, '010-1234-5678', 'hong1234@ncs.kr', 
        default, default, default, default, default, null);
        
INSERT INTO MEMBER
VALUES ('user02', 'pass02', '�Ż��Ӵ�', 'F', 45, '010-4545-9999', 'dano99@ncs.kr', 
        default, default, 'direct', default, default, null);
        

COMMIT;

-- notice ���̺�
DROP TABLE NOTICE;

CREATE TABLE NOTICE(
  NOTICENO NUMBER CONSTRAINT PK_NOTICENO PRIMARY KEY,
  NOTICETITLE VARCHAR2(50) NOT NULL,
  NOTICEDATE DATE DEFAULT SYSDATE,
  NOTICEWRITER VARCHAR2(50),
  NOTICECONTENT VARCHAR2(2000),
  ORIGINAL_FILEPATH VARCHAR2(100),
  RENAME_FILEPATH VARCHAR2(100),
  IMPORTANCE CHAR(1) DEFAULT 'N' NOT NULL,  
  IMP_END_DATE DATE DEFAULT SYSDATE NOT NULL,
  READCOUNT NUMBER DEFAULT 1 NOT NULL,
  CONSTRAINT FK_NOTICEWRITER FOREIGN KEY (NOTICEWRITER) 
      REFERENCES MEMBER ON DELETE SET NULL
);

COMMENT ON COLUMN notice.NOTICENO IS '�����۹�ȣ';
COMMENT ON COLUMN notice.NOTICETITLE IS '����������';
COMMENT ON COLUMN notice.NOTICEDATE IS '������ϳ�¥';
COMMENT ON COLUMN notice.NOTICEWRITER IS '�����ۼ���';
COMMENT ON COLUMN notice.NOTICECONTENT IS '��������';
COMMENT ON COLUMN notice.ORIGINAL_FILEPATH IS '����÷�����ϸ�';
COMMENT ON COLUMN notice.RENAME_FILEPATH IS '�ٲ�÷�����ϸ�';
COMMENT ON COLUMN notice.IMPORTANCE IS '�߿䵵';
COMMENT ON COLUMN notice.IMP_END_DATE IS '�߿䵵�Խ����ᳯ¥';
COMMENT ON COLUMN notice.READCOUNT IS '������ȸ��';

COMMIT;

INSERT INTO NOTICE VALUES (1, '���� ���� ����', SYSDATE, 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), 
'���� ���� ����2', SYSDATE, 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), '���� ���� ����3', SYSDATE, 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), '���� ���� ����4', SYSDATE, 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), '���� ���� ����5', SYSDATE, 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), '���� ���� ����6', SYSDATE, 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), '���� ���� ����7', SYSDATE, 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), '���� ���� ����8', SYSDATE, 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), '���� ���� ����9', SYSDATE, 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), '���� ���� ����10', SYSDATE, 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), '���Ի�� ��������', 
TO_DATE('2016-07-15', 'RRRR-MM-DD'), 'admin', 
'���� ���񽺰� ���µǾ����ϴ�. ���� �̿��� �ּ���.', null, null, DEFAULT, DEFAULT, DEFAULT);
INSERT INTO NOTICE VALUES ((select max(noticeno) + 1 from notice), '���Ի�� �������� ����', 
TO_DATE('2016-07-20', 'RRRR-MM-DD'), 'admin', 
'2016�� 7�� 20�� 18�ÿ� ���Ի�� ������ �����մϴ�.', null, null, DEFAULT, DEFAULT, DEFAULT);

SELECT * FROM NOTICE;
 
commit;



-- BOARD TABLE SCRIPT FILE
DROP TABLE BOARD;

CREATE TABLE BOARD(
	BOARD_NUM	NUMBER,	
	BOARD_WRITER	 VARCHAR2(50) NOT NULL,
	BOARD_TITLE	VARCHAR2(50) NOT NULL,
	BOARD_CONTENT	VARCHAR2(2000) NOT NULL,
	BOARD_ORIGINAL_FILENAME	VARCHAR2(100),
    BOARD_RENAME_FILENAME VARCHAR2(100),
    BOARD_REF NUMBER,
	BOARD_REPLY_REF	NUMBER,
	BOARD_LEV	NUMBER DEFAULT 1,
	BOARD_REPLY_SEQ NUMBER DEFAULT 1,
	BOARD_READCOUNT	NUMBER DEFAULT 0,
	BOARD_DATE	DATE DEFAULT SYSDATE,
  CONSTRAINT PK_BOARD PRIMARY KEY (BOARD_NUM),
  CONSTRAINT FK_BOARD_WRITER FOREIGN KEY (BOARD_WRITER) REFERENCES MEMBER (USERID) ON DELETE CASCADE
);

COMMENT ON COLUMN BOARD.BOARD_NUM IS '�Խñ۹�ȣ';
COMMENT ON COLUMN BOARD.BOARD_WRITER IS '�ۼ��ھ��̵�';
COMMENT ON COLUMN BOARD.BOARD_TITLE IS '�Խñ�����';
COMMENT ON COLUMN BOARD.BOARD_CONTENT IS '�Խñ۳���';
COMMENT ON COLUMN BOARD.BOARD_DATE IS '�ۼ���¥';
COMMENT ON COLUMN BOARD.BOARD_ORIGINAL_FILENAME IS '����÷�����ϸ�';
COMMENT ON COLUMN BOARD.BOARD_RENAME_FILENAME IS '�ٲ�÷�����ϸ�';
COMMENT ON COLUMN BOARD.BOARD_REF IS '���۹�ȣ';  -- ���۹�ȣ : ���� - �ڱ��ȣ, ���/���� : ���۹�ȣ
COMMENT ON COLUMN BOARD.BOARD_REPLY_REF IS '������۹�ȣ';  -- ���� : null, ������ ��/��� : �ڱ��ȣ, ����� ��� : ������۹�ȣ
COMMENT ON COLUMN BOARD.BOARD_LEV IS '��۴ܰ�'; -- ���� : 1, ������ ��� : 2, ����� ��� : 3
COMMENT ON COLUMN BOARD.BOARD_REPLY_SEQ IS '��ۼ���'; -- ���� : 0, ���� ������ ����� �� : 1 ....... ����ó��

INSERT INTO BOARD 
VALUES (1, 'admin', '������ �Խñ�', '���� ����Ʈ�� �̿��� �ּż� �����մϴ�.', 
NULL, NULL, 1, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (2, 'user01', 'MVC Model2', '�� ���ø����̼� ���� ��� �� MVC ������ ���� ��2 ����� �� �����Դϴ�.', 
NULL, NULL, 2, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (3, 'user02', '������2', '������ 2��°�δ� First Controller �� ����ϴ� ����� �ֽ��ϴ�.', 
NULL, NULL, 3, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (4, 'user01', '������3', '3��° ����� �׼��� �̿��ϴ� ����Դϴ�.', 
NULL, NULL, 4, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (5, 'user01', 'MVC Model2', '�� ���ø����̼� ���� ��� �� MVC ������ ���� ��2 ����� �� �����Դϴ�.', 
NULL, NULL, 5, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (6, 'user02', '������2', '������ 2��°�δ� First Controller �� ����ϴ� ����� �ֽ��ϴ�.', 
NULL, NULL, 6, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (7, 'user01', '������3', '3��° ����� �׼��� �̿��ϴ� ����Դϴ�.', 
NULL, NULL, 7, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (8, 'user01', 'MVC Model2', '�� ���ø����̼� ���� ��� �� MVC ������ ���� ��2 ����� �� �����Դϴ�.', 
NULL, NULL, 8, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (9, 'user02', '������2', '������ 2��°�δ� First Controller �� ����ϴ� ����� �ֽ��ϴ�.', 
NULL, NULL, 9, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (10, 'user01', '������3', '3��° ����� �׼��� �̿��ϴ� ����Դϴ�.', 
NULL, NULL, 10, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (11, 'user01', 'MVC Model2', '�� ���ø����̼� ���� ��� �� MVC ������ ���� ��2 ����� �� �����Դϴ�.', 
NULL, NULL, 11, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (12, 'user02', '������2', '������ 2��°�δ� First Controller �� ����ϴ� ����� �ֽ��ϴ�.', 
NULL, NULL, 12, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO BOARD 
VALUES (13, 'user01', '������3', '3��° ����� �׼��� �̿��ϴ� ����Դϴ�.', 
NULL, NULL, 13, null, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

SELECT * FROM BOARD;

COMMIT;

-- board ���̺� ��ȸ�� ���� ó��
update board
set board_readcount = 123
where board_num = 7;

update board
set board_readcount = 77
where board_num = 3;

update board
set board_readcount = 12
where board_num = 10;

commit;

--ajax �׽�Ʈ�� test ���̺� �����
drop table test cascade constraints;

create table test (
    name varchar2(30) unique not null,
    age number not null
);

insert into test values('ȫ�浿', 30);
insert into test values('�����', 25);
insert into test values('�̼���', 42);

commit;

select * from test;