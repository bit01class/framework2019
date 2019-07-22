CREATE TABLE STRUTS06 
(
  NUM NUMBER NOT NULL 
, NAME VARCHAR2(20) 
, SUB VARCHAR2(20) 
, CONTENT VARCHAR2(2000) 
, NALJA DATE 
, CONSTRAINT STRUTS06_PK PRIMARY KEY 
  (
    NUM 
  )
  ENABLE 
);
CREATE SEQUENCE STRUTS06_SEQ;
--dummy
insert into struts06 values (struts06_seq.nextval,'tester','test01','test',sysdate);
insert into struts06 values (struts06_seq.nextval,'tester','test02','test',sysdate);
insert into struts06 values (struts06_seq.nextval,'tester','test03','test',sysdate);
insert into struts06 values (struts06_seq.nextval,'tester','test04','test',sysdate);
insert into struts06 values (struts06_seq.nextval,'tester','test05','test',sysdate);
commit;