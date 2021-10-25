import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleMyBatisService;

public class OralceMyBatisMain6 {

	public static void main(String[] args) {
		OracleMyBatisService service= new OracleMyBatisService();
		//2.Multiupdate
		
		HashMap<String, Integer> map=new HashMap<>(); 
		map.put("key1", 10);
		map.put("key2", 20);
		
		List<Dept> list= service.multiSelectMap(map);
		for (Dept dept : list) {
			System.out.println(dept);
		}
	}

}
