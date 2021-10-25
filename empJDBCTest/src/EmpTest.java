


import java.util.ArrayList;
import java.util.HashMap;

import com.biz.EmpBiz;
import com.entity.EmpDTO;
import com.exception.DataNotFoundException;




public class EmpTest {

	
	public static void main(String[] args) throws DataNotFoundException {
		
		EmpBiz empBiz = new EmpBiz();//생성자 작성 -
//		empBiz.empInsert(new EmpDTO(30, "kim", "sales", 7902, null, 0.0, 0.1, 10));
	//	empBiz.empUpdate(new EmpDTO(30, "kim", "AAAAAA", 7902, null, 0.0, 0.1, 10));
		//dao.empUpdate : empno를 기준으로 job, sal을 update 후 num출력
		//update가 안된 경우 DataNotFoundEx발생
		
		try {
			empBiz.empDelete("99");
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<EmpDTO>list=empBiz.selectAllEmp();
		for (EmpDTO dto : list) {
			System.out.println(dto);
		}
		
		
		
		//EmpDTO dto= empBiz.selectDetailEmp("7369");
		//검색 조건 job="SALES"   ,  deptno=10   empBiz.select("SALES", 10);
//		HashMap<String, String> map = new HashMap<>();
//		map.put("job", "SALES");
//		map.put("deptno", "10");
//		ArrayList<EmpDTO> list = empBiz.selectDetailEmp2(map);
//		
		//System.out.println(empBiz.selectDetailEmp("30"));
		
		//ArrayList<EmpDTO> list = empBiz.selectAllEmp();	
		//System.out.println(list);
		
//		for (EmpDTO dto : list) {
//			System.out.println(dto);
//		}
		System.out.println("==============");
		
		
		
		
		
		
		//System.out.println(empBiz.selectDetailEmp("30"));
		//empBiz.empDelete("1");
	}//end main
}//end class
