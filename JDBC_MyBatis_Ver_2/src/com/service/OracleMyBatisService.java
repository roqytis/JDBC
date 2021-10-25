package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.config.MySqlSessionFactory;
import com.dao.OracleMyBatisDAO;
import com.dto.Dept;
import com.exception.RecordNotFoundException;

public class OracleMyBatisService {

	OracleMyBatisDAO dao;

	public OracleMyBatisService() {
		super();
		// TODO Auto-generated constructor stub
		dao = new OracleMyBatisDAO();

	}

	public void insert(Dept dept) {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			dao.insert(session, dept);
			session.commit();//명시적으로 꼭 해주어야 함. 
		} finally {
			session.close();
		}
	}

	public List<Dept> selectAll() {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		List<Dept> list = null;
		try {
			list = dao.selectAll(session);
		} finally {
			session.close();
		}
		return list;
	}
//	public ArrayList<Dept> select() throws SQLException{
//	
//		ArrayList<Dept> list= null;
//		try {//con닫기
//		 con= DriverManager.getConnection(url, userid, passwd);
//		 list = dao.select();		 
//		}finally {
//		
//		}
//		return list;
//	}
//	public void insert(Dept xx) {
//	
//	
//		try {//con닫기
//	
//			 dao.insert( xx);		 
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//		
//		}		
//	 }
//	public void update(Dept xx) throws RecordNotFoundException {
//		Connection con= null;
//	
//		try {//con닫기
//	
//			 dao.update(con, xx);		 
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			
//		}		
//	 }
//	public void delete(int i)  {
//	
//		
//		try {//con닫기
//
//			dao.delete(con, i);		 
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//
//		}		
//	}

}
