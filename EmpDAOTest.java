package javaexam1;

public class EmpDAOTest {
	public static void main(String[] args) {
		EmpDAO empdao = new EmpDAO();
		EmpDTO empdto = new EmpDTO();
		empdto.setEmpno(88);
		empdto.setEname("�̸���");
		empdto.setJob("�����Ͼ�");
		empdto.setMgr("999");
		empdto.setHiredate("2020-12-07");
		empdto.setSal("4000");
		empdto.setComm("777");
		empdto.setDeptno(10);
		empdao.insertEmp(empdto);
	}
}
