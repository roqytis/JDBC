package com.simpeDAO;

public class JDBCTest {

	public static void main(String[] args) {
		DeptDao dao =new DeptDao();
		dao.selectAllDept();

		dao.insertDept(new DeptDTO(99,"서울","부산"));

	}

}
