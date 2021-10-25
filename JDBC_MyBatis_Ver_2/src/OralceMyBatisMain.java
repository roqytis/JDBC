import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleMyBatisService;

public class OralceMyBatisMain {

	public static void main(String[] args) {
		OracleMyBatisService service= new OracleMyBatisService();
		service.insert(new Dept(99, "개발","강남"));
		List<Dept> list= service.selectAll();
		for (Dept dept : list) {
			System.out.println(dept);
		}

	}

}
