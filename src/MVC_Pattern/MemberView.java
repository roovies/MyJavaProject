package MVC_Pattern;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MemberView {
	Scanner sc;
	public MemberView() {
		sc = new Scanner(System.in);
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 0. 메인화면 출력
	/-------------------------------------------------------------------------------------------------*/
	public int mainPrint() {
		System.out.println("========== 회원관리 프로그램 =====");
		System.out.println("==\t1. 회원 가입\t\t==");
		System.out.println("==\t2. 전체 회원 조회\t==");
		System.out.println("==\t3. 회원 아이디로 조회\t==");
		System.out.println("==\t4. 회원 이름으로 조회\t==");
		System.out.println("==\t5. 회원 정보 변경\t==");
		System.out.println("==\t6. 회원 탈퇴\t\t==");
		System.out.println("==\t0. 프로그램 종료\t==");
		System.out.println("==================================");
		System.out.print("메뉴 입력: ");
		int input = sc.nextInt();
		return input;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 1. 회원가입 화면 출력
	/-------------------------------------------------------------------------------------------------*/
	public Member joinPrint() {
		Member member = null;
		while(true) {
			try {
				System.out.println("============= 입력 ===============");
				System.out.print("1. 아이디 입력: ");
				String memberId = sc.next();
				System.out.print("2. 패스워드 입력: ");
				String memberPw = sc.next();
				System.out.print("3. 이름 입력: ");
				String memberName = sc.next();
				System.out.print("4. 나이 입력: ");
				int memberAge = sc.nextInt();
				System.out.print("5. 성별 입력: ");
				String memberGender = sc.next();
				System.out.print("6. 이메일 입력: ");
				String memberEmail = sc.next();
				System.out.print("7. 번호 입력: ");
				String memberPhone = sc.next();
				System.out.print("8. 주소 입력: ");
				sc.nextLine();
				String memberAddr = sc.nextLine();
				System.out.print("9. 취미 입력: ");
				String memberHobby = sc.next();
				System.out.println("==================================");
				//입력된 정보로 Member 객체 생성 후 return
				member = new Member(memberId, memberPw, memberName, memberAge, memberGender, memberEmail, memberPhone, memberAddr, memberHobby);
				return member;
			}catch(InputMismatchException e) {
				System.out.println("문자를 입력할 수 없습니다. 숫자를 입력해주세요.");
				sc.nextLine();
				continue;
			} 
		}
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 2. 전체 회원 조회 화면 출력
	/-------------------------------------------------------------------------------------------------*/
	public void allPrint(List<Member> memList) {
		for(int i=0; i<memList.size(); i++) {
			Member member = memList.get(i);
			System.out.println(member.information(member));
		}
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 3. 아이디 검색 화면 출력
	/-------------------------------------------------------------------------------------------------*/
	// (1). 아이디 입력 화면  --> 아이디 입력 기능은 [5. 회원정보 변경] 및 [6. 회원탈퇴] 기능에서 재사용
	public String idSearch_Print() {
		System.out.println("==================================");
		System.out.print("아이디 입력:");
		String memberId = sc.next();
		return memberId;
	}
	// (2). 회원 아이디로 조회 결과 화면 출력
	public void idResult_Print(Member member, String memberId) {
		if(member==null) 
			System.out.println(memberId+"는(은) 존재하지 않는 회원입니다.");
		else
			System.out.println(member.information(member));
		System.out.println("==================================");
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 4. 이름 검색화면 출력
	/-------------------------------------------------------------------------------------------------*/
	// (1). 이름 입력 화면 출력
	public String nameSearch_Pirnt() {
		System.out.println("==================================");
		System.out.print("이름 입력:");
		String memberName = sc.next();
		return memberName;
	}
	// (2). 이름 검색 결과 화면 출력
	public void nameResult_Print(Member member, String memberName) {
		if(member==null)
			System.out.println("이름이"+memberName+"인 회원은 존재하지 않습니다.");
		else
			System.out.println(member.information(member));
		System.out.println("==================================");
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 5. 회원 정보 변경 화면 출력
	/-------------------------------------------------------------------------------------------------*/
	// (1). 아이디 존재여부에 따라 변경할 항목 선택 화면 출력
	// 이런 if문은 main에서 처리하고, 메소드를 분리하는 게 더 가독성에 좋은 것 같다. (단, 출력해야 되는 메소드는 증가함)
	// 에러반환 메소드, 성공반환 메소드를 구분해두면 좋을 듯.
	public int changeChoice_Print(Member member, String memberId) {
		while(true) {
			try {
				if(member==null) {
			System.out.println(memberId+"는(은) 존재하지 않는 회원입니다.");
			System.out.println("==================================");
			return 0;
			}	
			else {
				System.out.println(memberId+"의 변경할 정보를 선택해주세요.");
				System.out.println("> 1. 아이디");
				System.out.println("> 2. 패스워드");
				System.out.println("> 3. 이름");
				System.out.println("> 4. 나이");
				System.out.println("> 5. 성별");
				System.out.println("> 6. 이메일");
				System.out.println("> 7. 번호");
				System.out.println("> 8. 주소");
				System.out.println("> 9. 취미");
				System.out.println("==================================");
				System.out.print("선택: ");
				int choice = sc.nextInt();
				return choice;
			}
			}catch(InputMismatchException e) {
				System.out.println("문자를 입력할 수 없습니다. 숫자를 입력해주세요.");
				System.out.println("==================================");
				sc.nextLine();
				continue;
			}
		}
		
	}
	// (2). 각각의 정보 변경 화면 출력
	public String change_Print(String category) { 				//String 타입 항목 변경화면
		System.out.print("변경할 "+category+" 입력: ");
		String content = sc.next();
		return content;
	}
	
	public int change_Print2(String category) { 				//int 타입 항목 변경화면
		while(true) {
			try {
				System.out.print("변경할 "+category+" 입력: ");
				int content = sc.nextInt();
				return content;
			}catch(InputMismatchException e) {
				System.out.println("문자를 입력할 수 없습니다. 숫자를 입력해주세요.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 6. 회원 탈퇴 확인 화면
	/-------------------------------------------------------------------------------------------------*/
	public String checkRemove_Print(Member member, String id) {
		if(member==null) {
			System.out.println(id+"는(은) 존재하지 않는 회원입니다.");
			System.out.println("==================================");
			return "X";
		}
		else {
			System.out.println("정말 ["+id+"] 계정을 삭제하시겠습니까? (Y/N)");
			System.out.print(">> ");
			String choice = sc.next();
			return choice;
		}
	}
	public void successRemove_Print(String id) {
		System.out.println("["+id+"] 계정을 성공적으로 삭제했습니다.");
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 0. 기타 메시지 출력
	/-------------------------------------------------------------------------------------------------*/
	public void displayBye() { //종료메시지
		System.out.println("@@ 프로그램을 종료합니다. @@");
	}
	
	public void displayError() { //에러메시지
		System.out.println("※ 잘못된 입력 또는 접근입니다. 다시 정상적으로 시도해주세요.");
	}
	
}
