package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.Dept;
import com.exception.RecordNotFoundException;

public class OracleMyBatisDAO {
	// 1. 4가지 정보
	
	public OracleMyBatisDAO() {
	
	}
	//////////////////////////////////////////////
	public List<Dept> selectAll(SqlSession session){
		//<select id="selectAll" resultType="com.dto.dept">
		//session 객체에 db연결 , preparedStatment를 활용 sql 을 생성해줌 
		// select문실행 : select결과가 하나인 경우 session.select()사용
		//             select결과가 여러개인 경우 session.selectList()사용
		//insert문 insert()함수, update문 update()함수, delete문 delete()함수 사용
		//mapper.xml의 sql문장의 id값을 이용해서 sql을 찾아서 실행함 
		List<Dept> list= session.selectList("selectAll");//mapper의 sql의 id값 지정 
		System.out.println("in dao  list : " + list);
		return list;
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
