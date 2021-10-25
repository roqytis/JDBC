package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.OracleDAO;
import com.dto.Dept;
import com.exception.RecordNotFoundException;

public class OracleService {
	OracleDAO dao;
	
	public OracleService() {
		dao= new OracleDAO();
	}
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Dept> select() throws SQLException {
		ArrayList<Dept> list= dao.select();
		return list;
	}
	public void insert(Dept xx) {
		dao.insert(xx);
	}
	public void update(Dept xx) throws RecordNotFoundException {
		dao.update(xx);
	}
	
	public void delete(int i) {
		dao.delete(i);
	}

}
