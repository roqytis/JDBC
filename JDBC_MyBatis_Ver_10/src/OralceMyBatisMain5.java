import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.dto.Dept;
import com.exception.RecordNotFoundException;
import com.service.OracleMyBatisService;

public class OralceMyBatisMain5 {

	public static void main(String[] args) {
		OracleMyBatisService service= new OracleMyBatisService();
		List<Integer> deptnoes= Arrays.asList(10,20);
		List<Dept> list= service.multiSelect(deptnoes);
		for (Dept dept : list) {
			System.out.println(dept);
		}
	}

}
