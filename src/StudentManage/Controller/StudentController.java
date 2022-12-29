package StudentManage.Controller;

import java.util.ArrayList;
import java.util.List;

import StudentManage.Model.DAO.StudentDAO;
import StudentManage.Model.VO.Student;

public class StudentController {
	// 객체 선언 및 초기화
	// null로 초기화해준 이유는, 객체가 존재하지 않을 때(즉 데이터가 없을 경우) null을 반환함으로써
	// main메소드에서 데이터가 존재하지 않다고 처리해주기 위해서이다.
	StudentDAO sDAO = null;
	Student student = null;
	List<Student> sList = null;
	public StudentController(){
		sDAO = new StudentDAO(); //그래서 DAO만 객체로 생성함.
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 로그인 기능
	/-------------------------------------------------------------------------------------------------*/
	public int login(String loginId, String loginPwd) {
		student = sDAO.selectAdmin(loginId, loginPwd); 	// 입력한 ID,PW를 통해 DB에서 레코드를 반환받음.
		if(student!=null) { 							// 만약 입력한 ID,PW가 존재한다면 객체를 생성해서 반환할 것이므로 null이 아니다.
			if("admin".equals(student.getStudentId())) 	// Select한 계정의 ID가 admin하고 일치하는지 확인
				return 1;								/** 해당 코드는 SQLi 취약점이 존재한다. 'or'a'='a'--에 무력화됨 */
			return 0;
		}
		else // student 객체가 null이므로 계정이 존재하지 않는 것(select한 결과가 없는 것)
			return 0;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 회원가입 기능
	/-------------------------------------------------------------------------------------------------*/
	public int register(Student student) {
		int result = sDAO.insertStudent(student);
		return result;		
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 회원탈퇴 기능
	/-------------------------------------------------------------------------------------------------*/
	public int remove(String studentId) {
		int result = sDAO.deleteId(studentId);
		return result;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 전체 학생 조회 기능
	/-------------------------------------------------------------------------------------------------*/
	public List<Student> searchAll() {
		sList = sDAO.selectAll();
		return sList;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ ID, 이름으로 학생 조회 기능
	/-------------------------------------------------------------------------------------------------*/
	public Student searchId(String studentId) {
		student = sDAO.selectId(studentId);
		return student;
	}
	
	public List<Student> searchName(String studentName) {
		sList = sDAO.selectName(studentName);
		return sList;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 학생정보 수정 기능
	/-------------------------------------------------------------------------------------------------*/
	public int modifyPwd(Student student, String modifyData) {
		student.setStudentPwd(modifyData); //수정할 데이터를 계정(객체)에 저장
		int result = sDAO.updatePwd(student);
		return result;
	}
	
	public int modifyEmail(Student student, String modifyData) {
		student.setEmail(modifyData);
		int result = sDAO.updateEmail(student);
		return result;
	}
	
	public int modifyPhone(Student student, String modifyData) {
		student.setPhone(modifyData);
		int result = sDAO.updatePhone(student);
		return result;
	}
	
	public int modifyAddress(Student student, String modifyData) {
		student.setAddress(modifyData);
		int result = sDAO.updateAddress(student);
		return result;
	}
	public int modifyHobby(Student student, String modifyData) {
		student.setHobby(modifyData);
		int result = sDAO.updateAddress(student);
		return result;
	}
}
