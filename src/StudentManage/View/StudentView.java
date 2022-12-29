package StudentManage.View;

import java.util.List;
import java.util.Scanner;

import StudentManage.Model.VO.Student;

public class StudentView {
	Scanner sc;
	public StudentView() {
		sc = new Scanner(System.in);
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 로그인 화면
	/-------------------------------------------------------------------------------------------------*/
	public String loginIdView() {
		System.out.print("관리자 아이디 입력: ");
		String loginId = sc.next();
		return loginId;
	}
	public String loginPwdView() {
		System.out.print("관리자 비밀번호 입력: ");
		String loginPwd = sc.next();
		return loginPwd;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 메인화면
	/-------------------------------------------------------------------------------------------------*/
	public int mainView() {
		System.out.println();
		System.out.println("======== 학생관리 프로그램 =======");
		System.out.println("==\t1. 회원 가입\t\t==");
		System.out.println("==\t2. 전체 학생 조회\t==");
		System.out.println("==\t3. ID로 학생 조회\t==");
		System.out.println("==\t4. 이름으로 학생 조회\t==");
		System.out.println("==\t5. 학생 정보 변경\t==");
		System.out.println("==\t6. 회원 탈퇴\t\t==");
		System.out.println("==\t0. 프로그램 종료\t==");
		System.out.println("==================================");
		System.out.print("메뉴 입력: ");
		int select = sc.nextInt();
		return select;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 회원가입 화면
	/-------------------------------------------------------------------------------------------------*/
	public Student registerView() {
		System.out.println("=========== 회원 가입 ============");
		System.out.print("1. 아이디 : ");
		String id = sc.next();
		System.out.print("2. 패스워드 : ");
		String pwd = sc.next();
		System.out.print("3. 이름 : ");
		String name = sc.next();
		System.out.print("4. 성별(M, F) : ");
		String gender = sc.next();
		System.out.print("5. 나이 : ");
		int age = sc.nextInt();
		System.out.print("6. 이메일 : ");
		String email = sc.next();
		System.out.print("7. 번호 : ");
		String phone = sc.next();
		System.out.print("8. 주소 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		System.out.print("9. 취미(,로 구분): ");
		String hobby = sc.nextLine();
		System.out.println("==================================");
		Student student = new Student(id, pwd, name, gender, age, email, phone, addr, hobby, null);
		return student;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ ID, 이름 입력화면
	/-------------------------------------------------------------------------------------------------*/
	public String inputIdView(String msg) {
		System.out.print(msg+"할 ID 입력: ");
		String studentId = sc.next();
		return studentId;
	}
	
	public String inputNameView(String msg) {
		System.out.print(msg+"할 이름 입력: ");
		String studentName = sc.next();
		return studentName;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 전체 학생 조회 결과
	/-------------------------------------------------------------------------------------------------*/
	public void allstudentView(List<Student> sList) {
		System.out.println("=========================================================================================================="
				+ "===================================================================");
		System.out.printf("%12s %13s %8s %5s %5s %10s %15s %25s %25s %17s\n",
						"[아이디]", "[비밀번호]", "[이름]", "[성별]", "[나이]", "[이메일]", "[연락처]", "[주소]", "[취미]", "[가입일]");
		System.out.println("=========================================================================================================="
				+ "===================================================================");
		
		for(int i=0; i<sList.size(); i++) {
			System.out.printf("%15s ", sList.get(i).getStudentId());
			System.out.printf("%15s ", sList.get(i).getStudentPwd());
			System.out.printf("%9s ", sList.get(i).getStudentName());
			System.out.printf("%6s ", sList.get(i).getGender());
			System.out.printf("%7s ", sList.get(i).getAge());
			System.out.printf("%20s ", sList.get(i).getEmail());
			System.out.printf("%15s ", sList.get(i).getPhone());
			System.out.printf("%25s ", sList.get(i).getAddress());
			System.out.printf("%17s ", sList.get(i).getHobby());
			System.out.printf("%18s ", sList.get(i).getEnrollDate());
			System.out.println();
		}
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 특정 학생 조회 결과
	/-------------------------------------------------------------------------------------------------*/
	public void onestudentView(Student student) {
		System.out.println("=========================================================================================================="
				+ "===================================================================");
		System.out.printf("%12s %13s %8s %5s %5s %10s %15s %25s %25s %17s\n",
						"[아이디]", "[비밀번호]", "[이름]", "[성별]", "[나이]", "[이메일]", "[연락처]", "[주소]", "[취미]", "[가입일]");
		System.out.println("=========================================================================================================="
				+ "===================================================================");
		System.out.printf("%15s ", student.getStudentId());
		System.out.printf("%15s ", student.getStudentPwd());
		System.out.printf("%9s ", student.getStudentName());
		System.out.printf("%6s ", student.getGender());
		System.out.printf("%7s ", student.getAge());
		System.out.printf("%20s ", student.getEmail());
		System.out.printf("%15s ", student.getPhone());
		System.out.printf("%25s ", student.getAddress());
		System.out.printf("%17s ", student.getHobby());
		System.out.printf("%18s ", student.getEnrollDate());
		System.out.println();
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 정보수정 화면
	/-------------------------------------------------------------------------------------------------*/
	public int modifyListView() {
		System.out.println("수정할 항목을 선택하세요.");
		System.out.println(">> 1. 패스워드 변경");
		System.out.println(">> 2. 이메일 변경");
		System.out.println(">> 3. 연락처 변경");
		System.out.println(">> 4. 주소 변경");
		System.out.println(">> 5. 취미 변경");
		System.out.print(">> ");
		int select = sc.nextInt();
		return select;
	}
	
	public String modifyView(Student student, String msg) {
		System.out.println("["+student.getStudentId()+"]계정의 변경할 "+msg+"(을)를 입력해주세요.");
		System.out.print("입력>> ");
		sc.nextLine();
		String modifyData = sc.nextLine();
		return modifyData;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 성공/실패 화면
	/-------------------------------------------------------------------------------------------------*/
	public void successView(String msg) {
		System.out.println(msg+"에 성공하였습니다.");
	}

	public void errorView(String msg) {
		System.out.println("[오류 메시지]: "+msg);
		System.out.println("다시 시도해주세요.");
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 프로그램 종료 메시지
	/-------------------------------------------------------------------------------------------------*/
	public void closeView() {
		System.out.println("@@ 프로그램을 정상적으로 종료했습니다. @@");
	}
	
}
