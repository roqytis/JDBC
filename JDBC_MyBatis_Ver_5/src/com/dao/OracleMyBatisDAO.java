package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.Dept;
import com.exception.RecordNotFoundException;

public class OracleMyBatisDAO {
	// 1. 4가지 정보
	
	public OracleMyBatisDAO() {
	
	}
	public List<Dept> selectAll(SqlSession session){
		//<select id="selectAll" resultType="com.dto.dept">
//		List<Dept> list= session.selectList("selectAll");
		List<Dept> list= session.selectList("com.dept.DeptMapper2.selectAll");
		return list;
	}
	
	public void insert(SqlSession session, Dept dept) {
		int num= session.insert("deptInsert", dept);
		System.out.println("추가된 레코드 ===="+ num);
	}

	public void update(SqlSession session, Dept dept) {
		int num=session.update("deptUpdate",dept);
		System.out.println("업데이트된 레코드===="+num);
		
	}
	public Dept selectByDeptno(SqlSession session, int deptno) {
		Dept dept=session.selectOne("selectByDeptno" ,deptno);
		return dept;
	}
	public void delete(SqlSession session, int deptno) {
		int num= session.delete("deptDelete",deptno);
		System.out.println("삭제된 갯수====="+num);
	}
	public int deptRecordCount(SqlSession session) {
		int num= session.selectOne("deptRecordCount");
		return num;
	}
	public HashMap selectByDeptnoHashMap(SqlSession session, int deptno) {
		HashMap map= session.selectOne("selectByDeptHashmap",deptno);
		return map;
	}
	
	
	//	
//	public ArrayList<Dept> select(Connection con) throws SQLException {
//		ArrayList<Dept> list = new ArrayList<Dept>();
//		PreparedStatement pstmt= null;
//		ResultSet rs= null;
//	
//		String sql="select deptno x, dname, loc  from dept";
//		pstmt= con.prepareStatement(sql);
//		rs= pstmt.executeQuery();
//		while (rs.next()) {
//			int deptno = rs.getInt("x");
//			String dname = rs.getString(2);
//			String loc = rs.getString("loc");
//			//System.out.println(deptno + "\t" + dname + "\t" + loc);
//			Dept dto = new Dept(deptno, dname, loc);
//			list.add(dto);
//		}		
//		
//		if(rs!= null) rs.close();
//		if(pstmt!= null) pstmt.close();
//	
//		
//		return list;
//	}
//	public void insert(Connection con, Dept xx) {
//		
//		PreparedStatement pstmt= null;
//		try {
//		
//			String sql="insert into dept(deptno, dname, loc)"
//					+"values (?,?,?)";
//			pstmt= con.prepareStatement(sql);
//			pstmt.setInt(1, xx.getDeptno());
//			pstmt.setString(2, xx.getDname());
//			pstmt.setString(3, xx.getLoc());
//			int num= pstmt.executeUpdate();
//			System.out.println("실행 결과"+ num);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				// 7. 자원반납			
//				if (pstmt != null)
//					pstmt.close();
//			
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}	
//	}
//	public void update(Connection con, Dept xx) throws RecordNotFoundException  {
//			
//		
//		PreparedStatement pstmt= null;		
//		try {
//		
//			String sql="update dept set dname=? , loc=? where deptno=?";
//			pstmt= con.prepareStatement(sql);
//			pstmt.setString(1, xx.getDname());
//			pstmt.setString(2, xx.getLoc());
//			pstmt.setInt(3, xx.getDeptno());
//			int num= pstmt.executeUpdate();
//			System.out.println("실행 결과"+ num);		
//			if(num ==0 ) {
//				throw new RecordNotFoundException(xx.getDeptno()+"레코드가 없음");
//			}
//		}catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				// 7. 자원반납			
//				if (pstmt != null)
//					pstmt.close();
//		
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}	
//	}
//	public void delete(Connection con, int i) {
//	
//		PreparedStatement pstmt= null;		
//		try {
//			
//			//String sql="delete from dept where deptno= ?";  
//			String sql="dele from dept where deptno= ?"; //에러문장을 발생시킴
//			pstmt= con.prepareStatement(sql);			
//			pstmt.setInt(1,  i);
//			int num= pstmt.executeUpdate();
//			System.out.println("실행 결과"+ num);		
//		
//		}catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				// 7. 자원반납			
//				if (pstmt != null)
//					pstmt.close();
//	
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}	
//		
//	}
	
}
