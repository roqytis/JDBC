import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1.4가지 정보
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userid ="scott";
		String passwd ="tiger";
				
		//2.드라이버 생성=>new 이용
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩===============");
						
			//3.오라클 연결(Connection 연결)
			con=DriverManager.getConnection(url,userid,passwd);
			
			//4.sql 작성
		
			String sql="select deptno x,dname,loc from dept where dname=? and deptno=?";
  		//	String sql="select deptno x,dname,loc from dept where loc=?";
		//	String sql="select deptno x,dname,loc from dept where dname=?";
			
			//5.SQL 실행==> Statement, PreparedStatement,CallableStatement(PL/SQL)
			pstmt=con.prepareStatement(sql);//sql주입해서PreparedStatement 생성
			
			//6. 실행해서 결과받기
			pstmt.setString(1, "SALES");// dname data 설정, sql완성
			pstmt.setInt(2, 30);// dname data 설정, sql완성
		  
			System.out.println(sql);
			rs=pstmt.executeQuery();//select 실행
			
		    while (rs.next()) {
				int deptno =rs.getInt("x");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				System.out.println(deptno + "\t"+dname+"\t"+loc);
			}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		//3.오라클 연결(Connection 연결)
		
		
		
		
		
		//4.sql 작성
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
