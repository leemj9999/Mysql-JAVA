package javaexam1;

public class DeptDAOTest {
	public static void main(String[] args) {
		DeptDAO deptdao = new DeptDAO();
		DeptDTO deptdto = new DeptDTO();
		deptdto.setDeptno(78);
		deptdto.setDname("ȫ����");
		deptdto.setLoc("������ ȭ�");
		deptdao.insertDept(deptdto);
	}
}
