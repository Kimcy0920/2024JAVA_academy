package test;

import dept.DeptDAO;
import dept.DeptDTO;

public class Dept_Insert_Test {

	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		DeptDTO dto = new DeptDTO(0, "DOCTOR", "SEOUL");
		dao.getDeptInsert(dto);
		System.out.println();
	}

}
