import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Insert_1 {

	public static void main(String[] args) {
		//1. 4가지 정보
				String driver="oracle.jdbc.driver.OracleDriver";
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String userid ="scott";
				String passwd ="tiger";

		//2. 드라이버 생성=>new 이용
				Connection con= null;
				Statement stmt= null;
				ResultSet rs= null;
				
				//드라이빙로딩, 로딩성공 메세지 출력 후 컨넥션 연결
				try {
					Class.forName(driver);
					con=DriverManager.getConnection(url,userid,passwd);
					stmt =con.createStatement();
				
		//4. sql작성
			int deptno=89;
			String deptname="개발";
			String loc="서울";
			String sql= "insert into dept(deptno,dname,loc)"+"values("+deptno+
					",'"+deptname+"','"+loc+"')";
					System.out.println(sql);
					
					int result= stmt.executeUpdate(sql);//자동 커밋
					
					System.out.println("실행된 레코드 갯수:" +result);
					
					String sql2="select deptno, dname,loc from dept";
					rs=stmt.executeQuery(sql2);
					while (rs.next()) {
						System.out.println(rs.getInt(1)+":"+rs.getString(2)+
								":"+rs.getString(3));
					}
		//5.SQL 실행 ==> Statement, PreparedStatement, CallableStatement(PL/SQL)			
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
						if(con!=null)con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
	}

}
