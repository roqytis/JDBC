package com.simpeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userid ="scott";
	String passwd ="tiger";
	
	public DeptDao() {
		super();
		// TODO Auto-generated constructor stub
	try {
		Class.forName(driver);
		System.out.println("드라이버 로딩성공");
	
	} catch (ClassNotFoundException e){
		// TODO: handle finally clause
         e.printStackTrace();
	}
}

	public void selectAllDept() {
		// TODO Auto-generated method stub
		//로컬 변수
		Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
		con=DriverManager.getConnection(url,userid,passwd);
		
		System.out.println("Connection 연결===="+con);
		String sql="select deptno x,dname,loc from dept";
		
		//5.sql실행 ==>
		pstmt=con.prepareStatement(sql);
		//6.실행해서 결과 받기
		rs=pstmt.executeQuery();
		List<DeptDTO>list = new ArrayList<>();	
			while (rs.next()) {
				int deptno= rs.getInt("x");
				String dname=rs.getString("dname");
				String loc =rs.getString("loc");
				System.out.println("DAO : "+deptno + "\t"+dname+ "\t"+loc);
		        list.add(new DeptDTO(deptno,dname,loc));
			}
		System.out.println(list);	
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
				  rs.close();
				if(pstmt!=null)
				 pstmt.close();
				if(con!=null)
				 con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();// TODO: handle finally clause
		}
		}
	    }

	public int insertDept(DeptDTO dto) {
		// TODO Auto-generated method stub
		Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    int num=0;
	    try {
	    	con=DriverManager.getConnection(url,userid,passwd);
	    	
	    	String sql="insert into dept(deptno,dname,loc)"
	    			+"values(?,?,?)";
	    	
	    	pstmt=con.prepareStatement(sql);
	    	pstmt.setInt(1, dto.getDeptno());
	    	pstmt.setString(2, dto.getDname());
	    	pstmt.setString(3, dto.getLoc());
	    	
	    	 num=pstmt.executeUpdate();
	    	System.out.println("실행된 레코드 갯수:"+num);
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					  rs.close();
					if(pstmt!=null)
					 pstmt.close();
					if(con!=null)
					 con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}// TODO: handle finally clause
		}
		return num;
	    			
	}
	
}
	
	



