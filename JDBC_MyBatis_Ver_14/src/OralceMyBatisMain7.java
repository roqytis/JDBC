import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleMyBatisService;

public class OralceMyBatisMain7 {

	public static void main(String[] args) {
		OracleMyBatisService service= new OracleMyBatisService();
		
		//5. Top-N 분석 ==> 페이징처리
		List<Dept> deptList3= service.selectTopN("제주",0,1);
		for (Dept dept : deptList3) {
			System.out.println(">>>"+dept);
		}
	System.out.println("=================================");

	}

}
