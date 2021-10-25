package com.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
	static SqlSessionFactory sqlSessionFactory= null;
	static {//초기화
		String resource = "Configuration.xml";//Mybatis설정파일
		InputStream inputStream= null;
		try {
			inputStream = Resources.getResourceAsStream(resource);//Configuration.xml을 읽어올 수 있도록 Java IO연결
			System.out.println("초기화 Configuration.xml 등록 성공");
		} catch (IOException e) {//IOException 발생하면 파일경로나 이름이 틀린 경우가 대부분 
			e.printStackTrace();
		}
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //에러 
		 //configuration.xml에 문제가 있음. 
	}//end static
	
	public static SqlSession getSqlSession() {
		SqlSession session = sqlSessionFactory.openSession(); 
		return session;
	}
	
}
