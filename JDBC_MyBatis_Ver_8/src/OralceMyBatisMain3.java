import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleMyBatisService;

public class OralceMyBatisMain3 {

	public static void main(String[] args) {
		OracleMyBatisService service= new OracleMyBatisService();
		HashMap<String, Integer> map= new HashMap<>();
		map.put("key1", 10);
		map.put("key2", 12);
		List<Dept> list= service.selectByHashMap(map);
		for (Dept dept : list) {
			System.out.println(dept);
		}
		
		
		
		
		
		HashMap map2= service.selectByDeptnoHashMap(10);
		System.out.println(map2);//key와 value를 보여줌
	
		
		int num= service.deptRecordCount();
		System.out.println("레코드 갯수는 num==="+ num);
//		List<Dept> list= service.selectAll();
//		for (Dept dept : list) {
//			System.out.println(dept);
//		}
	}

}
