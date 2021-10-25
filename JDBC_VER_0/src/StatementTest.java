import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

	// ORACLE에 sql 실행하는 방법 Statment객체  이용, PreparedStatment를 이용 
	public static void main(String[] args) {
		//1. 4가지 정보
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe"; //SID일치 확인
		String userid ="scott";
		String passwd ="tiger";
		
		//2. 드라이버 생성=> new 이용
		Connection con = null;  //DB접속 ,  DriverManager를 통해 얻음
		//PreparedStatement pstmt =null;   // sql실행해줄 객체 , connection에서 얻어옴
		Statement stmt= null;   // sql실행해줄 객체 , connection에서 얻어옴
		ResultSet rs =null;  //sql select결과 저장 객체, Statement의 executeQuery실행 결과로 얻음 
		
		try {
			Class.forName(driver);   //2. 드라이버 생성(로딩)
		//3. 오라클 연결( Connection 연결) : Connection 얻기 
		 con = DriverManager.getConnection(url, userid, passwd);
		System.out.println("con====="+ con);   //Connection객체의 주소 
		//4. sql 작성  : 문자열로 작성
		 String sql="select * from dept ";  // ;제거
//		String sql="select deptno x,dname,loc from dept "; // ;제거
//		 String name="RESEARCH";
//		String sql="select deptno x,dname,loc from dept where dname='"+name+"'"; // ;제거
		
		
		//5. SQL 실행==> Connection에서 sql을 실행할 Statement, PreparedStatement 객체 얻기
		
		 stmt= con.createStatement();  //Statement객체 얻기 
		 //sql실행 준비 완료 
		 
		//6. Statement를 이용해서 sql실행 - select : executeQuery(), in, up, del : executeUpdate() 함수사용
		 rs= stmt.executeQuery(sql);//ResultSet에 전체 Select 결과 저장
		 //6-1 SQL 실행 결과 출력
		 ResultSetMetaData mrs= rs.getMetaData();   //결과에서 컬럼의 이름만 추출
		 int count = mrs.getColumnCount(); //컬럼수 추출 : 3
		for (int i = 1; i <=count; i++) {
			System.out.print(mrs.getColumnName(i)+"\t");  //컬럼 이름만 출력
		}
		System.out.println();
		System.out.println("===================================");
		 while(rs.next()) {
			
			 int deptno= rs.getInt("deptno");   //컬럼이름이용 데이터 가져오기 
			 String dname= rs.getString("dname"); //컬럼이름이용 데이터 가져오기 
			 String loc= rs.getString("loc"); //컬럼이름이용 데이터 가져오기 
//			 int deptno= rs.getInt(1);  //컬럼번호이용 데이터 가져오기
//			 String dname= rs.getString(2);
//			 String loc= rs.getString(3);
			 System.out.println(deptno+ "\t"+ dname+ "\t"+ loc);
		 }//end while
		 	}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("오라클 드라이버 로딩 실패 =====================");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					//7. 자원반납 반대순서로 실행 
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					if(con!=null)con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	}//end main
}
// end class
