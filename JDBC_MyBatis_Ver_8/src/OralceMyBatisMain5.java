import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleMyBatisService;

public class OralceMyBatisMain5 {

	public static void main(String[] args) {
		OracleMyBatisService service= new OracleMyBatisService();
		
		HashMap<String,String>map =new HashMap<String,String>();
	//	map.put("loc", "서울");
	//	map.put("dname", "개발");
		List<Dept> list= service.selectDynamicChoose(map);
		for (Dept dept : list) {
			System.out.println(dept);
		}
	}

}
