package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.common.util.JdbcTemplate;
import com.entity.EmpDTO;
import com.exception.DataNotFoundException;


public class EmpDAO {
	public ArrayList<EmpDTO> selectAllEmp(Connection con){
		ArrayList<EmpDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		  String sql = "select empno,ename,job,mgr, to_char(hiredate,'YYYY-MM-DD') hiredate,sal,comm,deptno from emp "
		  		+ "order by empno desc";	
		  pstmt = con.prepareStatement(sql);
		  rs = pstmt.executeQuery();
		  while(rs.next()){
			  int empno = rs.getInt("empno");
			  String ename = rs.getString("ename");
			  String job = rs.getString("job");
			  int mgr = rs.getInt("mgr");
			  String hiredate = rs.getString("hiredate");
			  double sal = rs.getDouble("sal");
			  double comm = rs.getDouble("comm");
			  int deptno = rs.getInt("deptno");
			  EmpDTO notice = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			  list.add(notice);
		  }
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);/////////////////////////////
			JdbcTemplate.close(pstmt);//////////////////////////
		}
		return list;
	}
	//사원번호로 찾기
	public EmpDTO selectDetailEmp(Connection con, String eno) throws DataNotFoundException{////ex throws
		EmpDTO result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		  String sql = "select empno,ename,job,mgr, to_char(hiredate,'YYYY-MM-DD')hiredate,sal,comm,deptno "
		  		+ "from emp where empno = ?";	
		  pstmt = con.prepareStatement(sql);
		  pstmt.setInt(1, Integer.parseInt(eno));/////형변환
		  rs = pstmt.executeQuery();
		  if(rs.next()){///if사용
			  int empno = rs.getInt("empno");
			  String ename = rs.getString("ename");
			  String job = rs.getString("job");
			  int mgr = rs.getInt("mgr");
			  String hiredate = rs.getString("hiredate");
			  double sal = rs.getDouble("sal");
			  double comm = rs.getDouble("comm");
			  int deptno = rs.getInt("deptno");
			  result = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
		  }else{//rs.next() false인경우 
			  throw new DataNotFoundException(eno+"에 해당하는 사원정보가 없습니다. 확인후 다시 조회하세요.");
		  }
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return result;//dto리턴
	}
	//수정하기
	public void empUpdate(Connection con, EmpDTO empDTO) throws DataNotFoundException{
		PreparedStatement pstmt = null;
		try{
		  String sql = "update emp set job = ?, sal = ? where empno = ?";	
		  pstmt = con.prepareStatement(sql);
		  pstmt.setInt(3, empDTO.getEmpno());
		  pstmt.setString(1, empDTO.getJob());
		  pstmt.setDouble(2, empDTO.getSal());
		  
		  int n = pstmt.executeUpdate();
		  System.out.println("update 갯수 = "+ n);
		  if(n==0) throw new DataNotFoundException(empDTO.getEmpno()+"에 해당하는 사원정보가 없습니다. 확인후 다시 조회하세요.");
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
	}
	public void empDelete(Connection con, String empno) throws DataNotFoundException{
		PreparedStatement pstmt = null;
		
		
		
		
		try{
		  String sql = "delete from emp where empno = ?";	
		  pstmt = con.prepareStatement(sql);
		  pstmt.setInt(1, Integer.parseInt(empno));
		  int n = pstmt.executeUpdate();	
		  if(n==0){
			  throw new DataNotFoundException(empno+"에 해당하는 사원정보가 없습니다. 확인후 다시 조회하세요.");
		  }
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
	}
	public void insert(Connection con, EmpDTO empDTO)  {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
		  String sql = "insert into emp values (?,?,?,?,sysdate,?,?,?)";	
		  pstmt = con.prepareStatement(sql);
		  pstmt.setInt(1, empDTO.getEmpno());
		  pstmt.setString(2, empDTO.getEname());
		  pstmt.setString(3, empDTO.getJob());
		  pstmt.setInt(4, empDTO.getMgr());
		  pstmt.setDouble(5, empDTO.getSal());
		  pstmt.setDouble(6, empDTO.getComm());
		  pstmt.setInt(7, empDTO.getDeptno());		  
		  
		  int n = pstmt.executeUpdate();
		 System.out.println("insert : 된 갯수   "+ n);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
	}
//	public ArrayList<EmpDTO> selectDetailEmp2(Connection con, HashMap<String, String> map) {
//		String job = map.get("job");
//		String no=map.get("deptno");
//		int deptno= Integer.parseInt(no);
//		System.out.println("dao map : " + job+ "\t"+ deptno);
//		
//		  String sql = "select empno,ename,job,mgr, to_char(hiredate,'YYYY-MM-DD')hiredate,sal,comm,deptno "
//			  		+ "from emp where job = ? and deptno=?";	
//		  
//		  //......
//		 // pstmt.setInt(2, deptno);
//		  // pstmt.setString(1, job);
//		  
//		return null;
//	}
}
