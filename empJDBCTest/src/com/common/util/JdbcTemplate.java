/*------------------------------------------------------------------------------
 * Name : JdbcTemplate
 * DESC : DB Connection�� ������ ��ȯ�ϴ� ���� �⺻���� ��ɵ��� ��Ƶ� util Ŭ����
 * VER  : 1.0
 * PROJ : VCC Phase I
 * Copyright 2011 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   ��        ��        ��        ��
 *------------------------------------------------------------------------------
 *     DATE      AUTHOR                       DESCRIPTION
 *-------------  --------  ----------------------------------------------------- 
 * 2011. 01. 01.  �濵���������   Ver1.0 �ۼ�
 *----------------------------------------------------------------------------*/

package com.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class JdbcTemplate {
	public static String driver="oracle.jdbc.driver.OracleDriver";
	public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String userid = "scott";
	public static String passwd = "tiger";
	
	public JdbcTemplate() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공======");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /**
     * Connection을 연결한 후 멤버 attribute 인 conn 에 Connection 객체를 세팅한 후 리턴한다.
     * 
     * @return Connection
     */
    public static Connection getConnection() {//connection연결
        Connection conn = null;
        try {            
            conn = DriverManager.getConnection(url,userid,passwd);
            conn.setAutoCommit(false);////////
        } catch (Exception e) {
            System.out.println("[JdbcTemplate.getConnection] : " + e.getMessage());
            e.printStackTrace();
        }
        return conn;//db연결, autocommit(false)
    }
    /**
     * DB와 Connect되었는지 여부를 Return 한다.     * 
     * @return DB와 Connect 되었는지 여부.
     */
    public static boolean isConnected(Connection conn) {
        boolean validConnection = true;
        try {
            if (conn == null || conn.isClosed())
                validConnection = false;
        } catch (SQLException e) {
            validConnection = false;
            e.printStackTrace();
        }
        return validConnection;
    }
    /**
     * Connection 객체를 시스템에 반환한다.
     */
    public static void close(Connection conn) {

        if (isConnected(conn)) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }    
    /**
     * Statement를 Close 한다.
     * 
     * @param stmt
     *            Statement 객체.
     */
    public static void close(Statement stmt) {

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ResultSet을 Close 한다.
     * 
     * @param result
     *            ResultSet 객체.
     */
    public static void close(ResultSet rset) {

        try {
            if (rset != null)
                rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 지금까지의 트랜잭션을 Commit 처리한다.
     */
    public static void commit(Connection conn) {

        try {
            if (isConnected(conn)) {
                conn.commit();
                System.out.println("[JdbcTemplate.commit] : DB Successfully Committed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 지금까지의 트랜잭션을 Rollback 처한다.
     */
    public static void rollback(Connection conn) {

        try {
            if (isConnected(conn)) {
                conn.rollback();
                System.out.println("[JdbcTemplate.rollback] : DB Successfully Rollbacked!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
