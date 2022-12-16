package MVC_Pattern;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		MemberView memView = new MemberView();
		MemberController memCon = new MemberController();
		done:
		while(true) {
			int choice = memView.mainPrint();
			switch(choice) {
			case 1: // 회원 가입
				Member joinMember = memView.joinPrint();
				memCon.joinMember(joinMember);
				break;
			case 2: // 전체 회원 조회
				List<Member> memList = memCon.allMember(); // return받는 데이터가 List<Member> 자료형
				memView.allPrint(memList);
				break;
			case 3: // 회원 아이디로 조회
				String inputId = memView.idSearch_Print();
				Member searchMember = memCon.searchId(inputId);
				memView.idResult_Print(searchMember, inputId);
				break;
			case 4: // 회원 이름으로 조회
				String inputName = memView.nameSearch_Pirnt();
				Member searchMember2 = memCon.searchName(inputName);
				memView.nameResult_Print(searchMember2, inputName);
				break;
			case 5: // 회원 정보 변경
				// 회원 정보를 변경하기 위해 아이디를 입력받고 판단
				String inputId2 = memView.idSearch_Print();
				Member searchMember3 = memCon.searchId(inputId2);
				int choiceinfo = memView.changeChoice_Print(searchMember3, inputId2);
				if(choiceinfo==1) {
					String content = memView.change_Print("아이디");
					memCon.changeId(searchMember3, content);
				}
				else if(choiceinfo==2) {
					String content = memView.change_Print("패스워드");
					memCon.changePw(searchMember3, content);
				}
				else if(choiceinfo==3) {
					String content = memView.change_Print("이름");
					memCon.changeName(searchMember3, content);
				}
				else if(choiceinfo==4) {
					int content = memView.change_Print2("나이");
					memCon.changeAge(searchMember3, content);
				}
				else if(choiceinfo==5) {
					String content = memView.change_Print("성별");
					memCon.changeGender(searchMember3, content);
				}
				else if(choiceinfo==6) {
					String content = memView.change_Print("이메일");
					memCon.changeEmail(searchMember3, content);
				}
				else if(choiceinfo==7) {
					String content = memView.change_Print("번호");
					memCon.changePhone(searchMember3, content);
				}
				else if(choiceinfo==8) {
					String content = memView.change_Print("주소");
					memCon.changeAddr(searchMember3, content);
				}
				else if(choiceinfo==9) {
					String content = memView.change_Print("취미");
					memCon.changeHobby(searchMember3, content);
				}
				else if(choiceinfo==0) 
					break;
				else
					memView.displayError();
				break;
			case 6: // 회원 탈퇴
				String removeId = memView.idSearch_Print();
				Member removeMember = memCon.searchId(removeId);
				String checkmsg = memView.checkRemove_Print(removeMember, removeId);
				if(checkmsg.equals("Y")) {
					memCon.removeAccount(removeMember);
					memView.successRemove_Print(removeId);
				}
				else if(checkmsg.equals("N"))
					break;
				else if(checkmsg.equals("X"))
					break;
				else
					memView.displayError();
				break;
			case 0:
				memView.displayBye();
				break done;

			}
		}
	}
}
