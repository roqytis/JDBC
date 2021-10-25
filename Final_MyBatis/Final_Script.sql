 drop table notice purge;
 create table notice
 ( no NUMBER(4) CONSTRAINT notice_no_pk PRIMARY KEY,
   title VARCHAR2(100) NOT NULL,
   content VARCHAR2(500) NOT NULL,
   author VARCHAR2(10) NOT NULL,
   writeday DATE NOT NULL);

 insert into notice ( no, title, content, author, writeday)
 values ( (select NVL(max(no),0)+1 from notice ), '2016년 하반기 임직원 워크샵','일시: 2016년 7월 25일 장소:지정연수원','인사팀', to_date('2016/07/10'));
 insert into notice ( no, title, content, author, writeday)
 values ( (select NVL(max(no),0)+1 from notice ), '전직원 대상 CJ전자 할인행사','일시:2016년 7월15일~20일 대상: 전임직원 할인율 30%','인사팀', to_date('2016/07/12'));
 
 select * from notice;

 drop table employee purge;
 create table employee
 ( empno NUMBER(4) CONSTRAINT employee_empno_pk PRIMARY KEY,
   ename VARCHAR2(10) NOT NULL,
   dname VARCHAR2(20) NOT NULL,
   loc   VARCHAR2(20) NOT NULL,
   sal   NUMBER(5) NOT NULL,
   hiredate DATE NOT NULL,
   state VARCHAR2(10) NOT NULL);
   
   insert into employee ( empno, ename, dname,loc,sal, hiredate , state ) 
   values ( 1000, '홍길동','영업','서울', 7000, to_char('2000/06/01'),'근무');
     insert into employee ( empno, ename, dname,loc,sal, hiredate , state) 
   values ( 2000, '임꺽정','영업','부산', 5000, to_char('2008/02/01'),'출장');
     insert into employee ( empno, ename, dname,loc,sal, hiredate , state) 
   values ( 3000, '이몽룡','영업','인천', 4500, to_char('2013/02/01'),'출장');
     insert into employee ( empno, ename, dname,loc,sal, hiredate , state ) 
   values ( 4000, '성춘향','개발','서울', 3500, to_char('2014/06/01'),'휴가');
     insert into employee ( empno, ename, dname,loc,sal, hiredate , state ) 
   values ( 4001, '김선달','개발','서울', 3500, to_char('2014/06/01'),'외출');
   commit;
   
   select * from notice;
   select * from employee;