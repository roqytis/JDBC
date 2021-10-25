import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleMyBatisService;

public class OralceMyBatisMain {

	public static void main(String[] args) {
		OracleMyBatisService service= new OracleMyBatisService();
		//service.insert(new Dept(99, "개발","강남"));
//		service.update(new Dept(99,"영업", "서울"));
//		Dept dept= service.selectByDeptno(99);
		service.delete(99);
		//System.out.println(dept);
		List<Dept> list= service.selectAll();
		for (Dept dept : list) {
			System.out.println(dept);
		}

	}

}
