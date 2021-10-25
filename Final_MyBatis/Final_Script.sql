 drop table notice purge;
 create table notice
 ( no NUMBER(4) CONSTRAINT notice_no_pk PRIMARY KEY,
   title VARCHAR2(100) NOT NULL,
   content VARCHAR2(500) NOT NULL,
   author VARCHAR2(10) NOT NULL,
   writeday DATE NOT NULL);

 insert into notice ( no, title, content, author, writeday)
 values ( (select NVL(max(no),0)+1 from notice ), '2016�� �Ϲݱ� ������ ��ũ��','�Ͻ�: 2016�� 7�� 25�� ���:����������','�λ���', to_date('2016/07/10'));
 insert into notice ( no, title, content, author, writeday)
 values ( (select NVL(max(no),0)+1 from notice ), '������ ��� CJ���� �������','�Ͻ�:2016�� 7��15��~20�� ���: �������� ������ 30%','�λ���', to_date('2016/07/12'));
 
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
   values ( 1000, 'ȫ�浿','����','����', 7000, to_char('2000/06/01'),'�ٹ�');
     insert into employee ( empno, ename, dname,loc,sal, hiredate , state) 
   values ( 2000, '�Ӳ���','����','�λ�', 5000, to_char('2008/02/01'),'����');
     insert into employee ( empno, ename, dname,loc,sal, hiredate , state) 
   values ( 3000, '�̸���','����','��õ', 4500, to_char('2013/02/01'),'����');
     insert into employee ( empno, ename, dname,loc,sal, hiredate , state ) 
   values ( 4000, '������','����','����', 3500, to_char('2014/06/01'),'�ް�');
     insert into employee ( empno, ename, dname,loc,sal, hiredate , state ) 
   values ( 4001, '�輱��','����','����', 3500, to_char('2014/06/01'),'����');
   commit;
   
   select * from notice;
   select * from employee;