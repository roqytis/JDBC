import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleService;

public class OralceMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OracleService service= new OracleService();
		//서비스 기본생성자 , dao생성코드 작성
		try {
			//service.select();
			ArrayList<Dept> list= service.select();
			for (Dept dept : list) {
				System.out.println(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		service.delete(99);
		Dept xx= new Dept(99, "영업","서울");
		//service.insert(xx);
		
		Dept xx2= new Dept(13, "제경", "부산");
		try {
			service.update(xx2);
		} catch (RecordNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			service.select();
			ArrayList<Dept> list= service.select();
			for (Dept dept : list) {
				System.out.println(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
