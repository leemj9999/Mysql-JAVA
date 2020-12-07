package javaexam1;

public class DeptDAOTest {
	public static void main(String[] args) {
		DeptDAO deptdao = new DeptDAO();
		DeptDTO deptdto = new DeptDTO();
		deptdto.setDeptno(78);
		deptdto.setDname("È«º¸ºÎ");
		deptdto.setLoc("°­¼­±¸ È­°îµ¿");
		deptdao.insertDept(deptdto);
	}
}
