import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleMyBatisService;

public class OralceMyBatisMain4 {

	public static void main(String[] args) {
		OracleMyBatisService service= new OracleMyBatisService();
		//map부서번호 10을  key/value로 넣어서 전달 
		// 부서번호가  map에 있는 경우는 10번 부서를 찾기   //   ... WHERE DEPTNO=10   ID: A
		// 부서번호가 map에 없는 경우 (NULL) 인 경우 전체 SELECT // SELECT FROM DEPT;  iD: B
		//동적 SQL의 활용 위 두가지 경우를 하나의 SQL 로 처리 
		int deptno=10;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("deptno", null);
//		map.put("deptno", deptno); //key값을  이용한 검사
		List<Dept> list= service.selectDynamicDeptno(map);
		for (Dept dept : list) {
			System.out.println(dept);
		}
	}

}
