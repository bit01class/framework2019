CREATE TABLE BBS02 
(
  NUM NUMBER NOT NULL 
, NAME VARCHAR2(20) 
, SUB VARCHAR2(20) 
, CONTENT VARCHAR2(2000) 
, NALJA DATE 
, CONSTRAINT BBS02_PK PRIMARY KEY 
  (
    NUM 
  )
  ENABLE 
);
CREATE SEQUENCE BBS02_SEQ;
-- dummy
insert into bbs02 values (bbs02_seq.nextval,'�׽���','����1','����1',sysdate);
insert into bbs02 values (bbs02_seq.nextval,'�׽���','����2','����2',sysdate);
insert into bbs02 values (bbs02_seq.nextval,'�׽���','����3','����3',sysdate);
insert into bbs02 values (bbs02_seq.nextval,'�׽���','����4','����4',sysdate);
insert into bbs02 values (bbs02_seq.nextval,'�׽���','����5','����5',sysdate);
commit;