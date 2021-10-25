import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleMyBatisService;

public class OralceMyBatisMain3 {

	public static void main(String[] args) {
		OracleMyBatisService service= new OracleMyBatisService();
	//	service.insert(new Dept(99,"aa","aa"));
	    HashMap<String,Integer> map=new HashMap<>();
	    map.put("key1", 10);
	    map.put("key2", 30);
		List<Dept>list=service.selectByHashMap(map);
		
		for (Dept dept : list) {
			System.out.println(">>>>"+dept);
		}
//		HashMap map =service.selectByDeptnoHashMap(10);
//        System.out.println("int map: "+map);
//        
//        Set keys=map.keySet();
//        System.out.println(keys);
//        for (Object key : keys) {
//			System.out.println(key+"\t");
//			System.out.println(map.get(key));
//		}
//		List<Dept> list= service.selectAll();
//		for (Dept dept : list) {
//			System.out.println(dept);
//		}

//		int num= service.deptRecordCount();
//		System.out.println("레코드 갯수는 num===="+num);
	}

}
