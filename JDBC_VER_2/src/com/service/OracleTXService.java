package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.OracleTxDAO;
import com.dto.Dept;
import com.exception.RecordNotFoundException;

public class OracleTXService {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "scott";
	String passwd = "tiger";
    OracleTxDAO dao;
    public OracleTXService() {
    	super();
    	dao=new OracleTxDAO();
    	try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		  e.printStackTrace();
		}
    }
	public ArrayList<Dept> select() throws SQLException {
		Connection con=null;
		ArrayList<Dept>list=null;
		try {
			con= DriverManager.getConnection(url,userid,passwd);
			list =dao.select(con);
	
		    System.out.println(list);
		} finally {
			if(con!=null)con.close();
		}
		return list;
	}

	public void delete(int i) {
		Connection con=null;
		
		try {
			con= DriverManager.getConnection(url,userid,passwd);
			dao.delete(con,i);
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null)con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	public void insert(Dept xx) {
		Connection con=null;
		try {
			con=DriverManager.getConnection(url,userid,passwd);
			dao.insert(con,xx);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void update(Dept xx2) throws RecordNotFoundException {
		Connection con=null;
		try {
			con=DriverManager.getConnection(url,userid,passwd);
			dao.update(con,xx2);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		}
	}
    



