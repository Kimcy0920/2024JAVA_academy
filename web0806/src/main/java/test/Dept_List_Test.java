package test;

import java.util.List;

import dept.DeptDAO;
import dept.DeptDTO;

public class Dept_List_Test {

	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		List<DeptDTO> list = dao.getDeptList();
		for (DeptDTO dto : list) {
			System.out.println(dto);
		}
	}

}
