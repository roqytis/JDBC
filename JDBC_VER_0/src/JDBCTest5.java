import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest5 {

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
		
			String sql="delete from dept where deptno=?";
  		//	String sql="select deptno x,dname,loc from dept where loc=?";
		//	String sql="select deptno x,dname,loc from dept where dname=?";
			
			//5.SQL 실행==> Statement, PreparedStatement,CallableStatement(PL/SQL)
			pstmt=con.prepareStatement(sql);//sql주입해서PreparedStatement 생성
			
			
			pstmt.setInt(1, 14);// dname data 설정, sql완성
			
			int num1=pstmt.executeUpdate();
			
			System.out.println("삭제된 데이터: "+num1);
			
			String sql2="select *from dept";
			pstmt=con.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+
						"\t"+rs.getString(3));
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
