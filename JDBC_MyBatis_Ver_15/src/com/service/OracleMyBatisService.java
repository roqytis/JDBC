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
	
	OracleMyBatisDAO dao= new OracleMyBatisDAO();//23라인과 동일한 의미 객체 생성시 자동 사용객체 생성
	// 저장함. 
	public OracleMyBatisService() {
		super();
//		dao= new OracleMyBatisDAO();//사용할 객체를  생성자에서 생성 초기화 	
	}
	
	public List<Dept> selectAll(){//전체목록선택
		SqlSession session= MySqlSessionFactory.getSqlSession();
		List<Dept> list = null;
		try {
		 list= dao.selectAll(session);
		}finally {
			session.close();
		}
		return list;
	}
	
	
	
	
	
	public List<Dept> selectAll2(){//전체목록선택
		SqlSession session= MySqlSessionFactory.getSqlSession();//connection 과 비슷한  SqlSession 얻기		 
		List<Dept> list = null;
		try {
			list= dao.selectAll(session);//dao에서 사용할  SqlSession넘기기- select실행 후 결과 받기 
		}finally {
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
