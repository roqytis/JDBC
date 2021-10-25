import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_update_1 {

	public static void main(String[] args) {
		
		//1. 4가지 정보
				String driver="oracle.jdbc.driver.OracleDriver";
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String userid ="scott";
				String passwd ="tiger";
       //드라이버 로딩, 성공 메세지, 컨넥션 연결, Statement 생성
				Connection con=null;
				Statement stmt=null;
				
				
					try {
						Class.forName(driver);
						
					//3. 오라클 연결(Connectio 연결)
					con=DriverManager.getConnection(url,userid,passwd);
												
						String dname="영업";
						String loc="제주";
						int deptno=90;
						
						String sql= "UPDATE dept set dname='"+dname+"',loc='"+loc+
								"'"+"where deptno="+deptno;
						System.out.println(sql);
						stmt=con.createStatement();
						
						//6. 실행해서 결과 받기
						int num=stmt.executeUpdate(sql);
						System.out.println("실행된 레코드 갯수:"+num);
							
						String sql2="select deptno from dept where deptno=90";
						System.out.println(sql2);
					
						
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


