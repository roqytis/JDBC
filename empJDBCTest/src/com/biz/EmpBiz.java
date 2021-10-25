package com.biz;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.common.util.JdbcTemplate;
import com.dao.EmpDAO;
import com.entity.EmpDTO;
import com.exception.DataNotFoundException;

public class EmpBiz {

	EmpDAO dao;
	
	public EmpBiz() {
		dao = new EmpDAO();
	}
	
	
	
	public ArrayList<EmpDTO> selectAllEmp(){
		Connection con = JdbcTemplate.getConnection();
		ArrayList<EmpDTO> list =  dao.selectAllEmp(con);
		JdbcTemplate.close(con);
		return list;
	}
	
	
	public EmpDTO selectDetailEmp( String eno) throws DataNotFoundException{//////////사용자 정의 ex추가
		Connection con = JdbcTemplate.getConnection();
		EmpDTO dto = dao.selectDetailEmp(con, eno);
		JdbcTemplate.close(con);
		return dto;
	}
	
	
	public void empUpdate( EmpDTO empDTO) throws DataNotFoundException{
		Connection con = JdbcTemplate.getConnection();
		dao.empUpdate(con, empDTO);
		JdbcTemplate.commit(con);
		JdbcTemplate.close(con);
	}
	public void empDelete( String empno) throws DataNotFoundException{
		Connection con = JdbcTemplate.getConnection();
		dao.empDelete(con, empno);
		JdbcTemplate.commit(con);
		JdbcTemplate.close(con);
	}
	public void empInsert( EmpDTO empDTO) throws DataNotFoundException{
		Connection con = JdbcTemplate.getConnection();
		dao.insert(con, empDTO);//num 값 출력 
		JdbcTemplate.commit(con);
		JdbcTemplate.close(con);
	}
//	public ArrayList<EmpDTO> selectDetailEmp2(HashMap<String, String> map) {
//		Connection con = JdbcTemplate.getConnection();
//		ArrayList<EmpDTO> list= dao.selectDetailEmp2(con, map);
//		//컨넥션 닫기 
//		return list;
//	}
}
