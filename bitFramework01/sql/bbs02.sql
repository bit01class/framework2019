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
insert into bbs02 values (bbs02_seq.nextval,'테스터','제목1','내용1',sysdate);
insert into bbs02 values (bbs02_seq.nextval,'테스터','제목2','내용2',sysdate);
insert into bbs02 values (bbs02_seq.nextval,'테스터','제목3','내용3',sysdate);
insert into bbs02 values (bbs02_seq.nextval,'테스터','제목4','내용4',sysdate);
insert into bbs02 values (bbs02_seq.nextval,'테스터','제목5','내용5',sysdate);
commit;