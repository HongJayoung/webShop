package com.kosta.model;

import java.util.List;
import java.util.Map;

import com.kosta.dto.EmpVO;
import com.kosta.dto.JobVO;

//사용자요청-->Controller-->Service-->DAO-->DB
//	 	<--			  <--		<--	  <--
public class EmpService {
	EmpDAO empDAO = new EmpDAO();
	//1.모든직원조회
	public List<EmpVO> selectAll() {
		return empDAO.selectAll();
	}
	
	//2.조건조회(특정부서)
	public List<EmpVO> selectByDept(int deptid) {
		return empDAO.selectByDept(deptid);
	}
	
	//3.조건조회(특정매니저)
	public List<EmpVO> selectByManager(int mid) {
		return empDAO.selectByManager(mid);
	}
	
	//4.조건조회(특정job)
	public List<EmpVO> selectByJob(String job_id) {
		return empDAO.selectByJob(job_id);
	}
	
	//5.조건조회(특정department_id, job_id, salary>=, hire_date>=)
	public List<EmpVO> selectByCondition(int deptid, String job_id, double sal, String hire_hate) {
		return empDAO.selectByCondition(deptid, job_id, sal, hire_hate);
	}
	//6.특정직원1건조회
	public EmpVO selectById(int empid) {
		return empDAO.selectById(empid);
	}
	
	//7.insert
	public int empInsert(EmpVO emp) {
		return empDAO.empInsert(emp);
	}
	
	//8.update(특정직원1건 employee_id=?)
	public int empUpdate(EmpVO emp) {
		return empDAO.empUpdate(emp);
	}
	
	//9.update(조건 department_id=?)
	public int empUpdateByDept(EmpVO emp, int deptid) {
		return empDAO.empUpdateByDept(emp, deptid);
	}
	
	//10.delete(특정직원1건 employee_id=?)
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}
	
	//11.delete(조건 department_id=?)
	public int empDeleteByDept(int deptid) {
		return empDAO.empDeleteByDept(deptid);
	}
	
	//12.모든직책조회
	public List<JobVO> selectAllJob() {
		return empDAO.selectAllJob();
	}
	
	//13.모든매니저조회
	public Map<Integer, String> selectAllMgr() {
		return empDAO.selectAllMgr();
	}
	
	//14. 이메일 중복체크
	public int selectByEmail(String email) {
		return empDAO.selectByEmail(email);
	}
}
