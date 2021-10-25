import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleTXService;

public class OralceTXMain2 {

	public static void main(String[] args) throws SQLException, RecordNotFoundException {
		OracleTXService service=new OracleTXService();

		//tx처리 : insertDelete호출
		
		service.insertDelete(new Dept(99,"개발","제주"),88);
		try {
			ArrayList<Dept> list = service.select();
			for (Dept dept : list) {
				System.out.println(dept);
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//드라이버 로딩, 커넥션 연결 4가지 정보 설정, dao생성
		//service.delete(99);
		//2번 클릭
//         int deptno=99;
//         String dname="개발";
//         String loc="제주";
//         Dept xx=new Dept(deptno,dname,loc);
//         service.insert(xx);
//		System.out.println(xx);
		
		//3번 클릭
		Dept xx2=new Dept(99,"경제","서울");
		service.update(xx2);
		
		
		
    //1번 클릭
		try {
			ArrayList<Dept> list = service.select();
					for (Dept dept : list) {
						System.out.println(dept);
					}
		} catch (SQLException e) {
			// TODO: handle exception
		   e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		ArrayList<Dept>list=service.select();
		   
		
		
	}

}
