import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest2 {

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
		
			String sql="insert into dept(deptno, dname,loc)"
					+ " values(?,?,?)";
  		//	String sql="select deptno x,dname,loc from dept where loc=?";
		//	String sql="select deptno x,dname,loc from dept where dname=?";
			
			//5.SQL 실행==> Statement, PreparedStatement,CallableStatement(PL/SQL)
			pstmt=con.prepareStatement(sql);//sql주입해서PreparedStatement 생성
			
			pstmt.setInt(1, 99);// dname data 설정, sql완성
			pstmt.setString(2, "영업");// dname data 설정, sql완성
			pstmt.setString(3, "제주");// dname data 설정, sql완성
			//6. 실행해서 결과받기
			int num=pstmt.executeUpdate();
			System.out.println("실행된 레코드 갯수: "+num);
			
			
			String sql2="select deptno,dname,loc from dept";
			pstmt=con.prepareStatement(sql2);
			rs=pstmt.executeQuery();
					
			while (rs.next()) {
				System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"
						+rs.getString(3));
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
