package StudentManage.Run;

import java.util.ArrayList;
import java.util.List;

import StudentManage.Controller.StudentController;
import StudentManage.Model.VO.Student;
import StudentManage.View.StudentView;

public class StudentRun {
	public static void main(String[] args) {
		StudentView sView = new StudentView();
		StudentController sCon = new StudentController();
		Student student = null;
		List<Student> sList = null;
		String studentId = "";
		String studentName= "";
		int result = 0;
		/**-------------------------------------------------------------------------------------------------
		/ 로그인
		/-------------------------------------------------------------------------------------------------*/
		String loginId = sView.loginIdView();
		String loginPwd = sView.loginPwdView();
		int loginresult = sCon.login(loginId, loginPwd);
		int select = 0;
		done :
		if(loginresult==1) {  //로그인 성공
			sView.successView("로그인");
			while(true) {
				select = sView.mainView();
				switch(select) {
				/**-------------------------------------------------------------------------------------------------
				/ 회원가입
				/-------------------------------------------------------------------------------------------------*/
				case 1 : 
					student = sView.registerView();
					int status = sCon.register(student);
					if(status==1) { //회원가입 성공
						sView.successView("회원가입");
						break;
					}
					else { //회원가입 실패
						sView.errorView("회원가입에 실패했습니다.");
						break;
					}
				/**-------------------------------------------------------------------------------------------------
				/ 전체 학생 조회
				/-------------------------------------------------------------------------------------------------*/
				case 2 :
					sList = sCon.searchAll();
					sView.allstudentView(sList);
					break;
				/**-------------------------------------------------------------------------------------------------
				/ ID로 학생 조회
				/-------------------------------------------------------------------------------------------------*/
				case 3 :
					studentId = sView.inputIdView("조회");
					student = sCon.searchId(studentId);
					if(student!=null)  //student객체가 null이 아니면 데이터가 존재함
						sView.onestudentView(student);						
					else
						sView.errorView("아이디가 존재하지 않습니다.");
					break;
				/**-------------------------------------------------------------------------------------------------
				/ 이름으로 학생 조회
				/-------------------------------------------------------------------------------------------------*/
				case 4 :
					studentName = sView.inputNameView("조회");
					sList = sCon.searchName(studentName);
					if(!sList.isEmpty()) //sList객체는 new를 통한 객체생성을 무조건 했기 때문에 담겨있는 데이터가 존재하는지를 확인해야 함.
						sView.allstudentView(sList);
					else
						sView.errorView("이름이 존재하지 않습니다.");
					break;
				/**-------------------------------------------------------------------------------------------------
				/ 학생 정보 변경
				/-------------------------------------------------------------------------------------------------*/
				case 5 : //학생 정보 변경 (아이디 검색 후 정보 변경)
					studentId = sView.inputIdView("정보를 수정");
					student = sCon.searchId(studentId);
					if(student!=null) {
						select = sView.modifyListView();
						String modifyData = "";
						if(select==1) {
							modifyData = sView.modifyView(student, "패스워드");
							result = sCon.modifyPwd(student, modifyData);
							if(result>0)
								sView.successView("패스워드 변경");
							else
								sView.errorView("패스워드 길이가 초과되었습니다.");
						}
						else if(select==2) {
							modifyData = sView.modifyView(student, "이메일");
							result = sCon.modifyEmail(student, modifyData);
							if(result>0)
								sView.successView("이메일 변경");
							else
								sView.errorView("이메일 길이가 초과되었습니다.");
						}
						else if(select==3) {
							modifyData = sView.modifyView(student, "연락처");
							result = sCon.modifyPhone(student, modifyData);
							if(result>0)
								sView.successView("연락처 변경");
							else
								sView.errorView("연락처 길이가 초과되었습니다.");
						}
						else if(select==4) {
							modifyData = sView.modifyView(student, "주소");
							result = sCon.modifyAddress(student, modifyData);
							if(result>0)
								sView.successView("주소 변경");
							else
								sView.errorView("주소 길이가 초과되었습니다.");
						}
						else if(select==5) {
							modifyData = sView.modifyView(student, "취미");
							result = sCon.modifyHobby(student, modifyData);
							if(result>0)
								sView.successView("취미 변경");
							else
								sView.errorView("취미 길이가 초과되었습니다.");
						}
						else
							sView.errorView("입력값이 올바르지 않습니다.");
					}
					else
						sView.errorView("아이디가 존재하지 않습니다.");
					break;
				/**-------------------------------------------------------------------------------------------------
				/ 회원탈퇴
				/-------------------------------------------------------------------------------------------------*/
				case 6 :
					studentId = sView.inputIdView("탈퇴");
					result = sCon.remove(studentId);
					if(result>0)
						sView.successView("회원 탈퇴");
					else
						sView.errorView("아이디가 존재하지 않습니다.");
					break;
				case 0 :
					sView.closeView();
					break done;
				}
			}
		}
		else 	//로그인 실패
			sView.errorView("아이디 또는 패스워드가 일치하지 않습니다.");

	}
}
