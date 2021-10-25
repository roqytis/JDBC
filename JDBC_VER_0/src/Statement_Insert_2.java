import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Insert_2 {

	public static void main(String[] args) {
		//1. 4가지 정보
				String driver="oracle.jdbc.driver.OracleDriver";
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String userid ="scott";
				String passwd ="tiger";

		//2. 드라이버 생성=>new 이용
				Connection con= null;
				Statement stmt= null;
				
				
				//드라이빙로딩, 로딩성공 메세지 출력 후 컨넥션 연결
				try {
					Class.forName(driver);
				    System.out.println("드라이버 로딩=========");
					con=DriverManager.getConnection(url,userid,passwd);
					stmt =con.createStatement();
				
		//4. sql작성
		String sql= "insert into dept(deptno,dname,loc)"+"values(13,'개발','서울')";
			stmt=con.createStatement();
			
			int num= stmt.executeUpdate(sql);//자동 커밋
					
				int deptno=14;
				String sql2="insert into dept(deptno,dname,loc)"
				+"values("+deptno+",'개발2','서울2')";
					
			int num2 =stmt.executeUpdate(sql2);
										
     			System.out.println("실행된 레코드 갯수:" + (num+num2));
			
		//5.SQL 실행 ==> Statement, PreparedStatement, CallableStatement(PL/SQL)			
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						//자원반납
						if(stmt!=null)stmt.close();
						if(con!=null)con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
	}

}
