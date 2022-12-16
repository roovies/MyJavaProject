package MVC_Pattern;

import java.util.ArrayList;
import java.util.List;

public class MemberController {
	List<Member> memList; // 전체 회원정보를 저장할 곳 (Database라 보면 됨)
	
	public MemberController() {
		memList = new ArrayList<Member>();	
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 1. 회원가입 기능
	/-------------------------------------------------------------------------------------------------*/
	public void joinMember(Member joinMember) {
		memList.add(joinMember); //ArrayList에 가입정보가 저장된 Member 객체 추가
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 2. 전체 회원 조회
	/-------------------------------------------------------------------------------------------------*/
	public List<Member> allMember() {
		// 전체 회원정보는 ArrayList에 저장되어 있으므로, memList를 반환.
		// memList는 자료형이 List<Member>이므로 메소드 타입을 List<Member>로 선언
		return memList; 
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 3, 5 회원 아이디 존재여부 확인
	/-------------------------------------------------------------------------------------------------*/
	public Member searchId(String memberId) {
		for(int i=0; i<memList.size(); i++) {
			if(memList.get(i).getMemberId().equals(memberId)) //전달받은 member객체의 id가 Member List에 존재하는지 확인
				return memList.get(i); //memberId가 존재하는 경우 해당 member객체 반환
		}
		return null; //객체를 반환할 때, 객체가 없는 경우(null)도 반환해줘야 함.
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 4. 회원 이름 존재여부 확인
	/-------------------------------------------------------------------------------------------------*/
	public Member searchName(String memberName) {
		for(int i=0; i<memList.size(); i++) {
			if(memList.get(i).getMemberName().equals(memberName))
				return memList.get(i);
		}
		return null;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 5. 회원 정보 변경
	/-------------------------------------------------------------------------------------------------*/
	public void changeId(Member member, String chId) {			// 아이디 변경
		member.setMemberId(chId);
	}
	public void changePw(Member member, String chPw) {			// 패스워드 변경
		member.setMemberPw(chPw);
	}
	public void changeName(Member member, String chName) {		// 이름 변경
		member.setMemberName(chName);
	}
	public void changeAge(Member member, int chAge) {			// 나이 변경
		member.setMemberAge(chAge);
	}
	public void changeGender(Member member, String chGender) {	// 성별 변경
		member.setMemberGender(chGender);
	}
	public void changeEmail(Member member, String chEmail) {	// 이메일 변경
		member.setMemberEmail(chEmail);
	}
	public void changePhone(Member member, String chPhone) {	// 번호 변경
		member.setMemberPhone(chPhone);
	}
	public void changeAddr(Member member, String chAddr) {		// 주소 변경
		member.setMemberAddr(chAddr);
	}
	public void changeHobby(Member member, String chHob) {		// 취미 변경
		member.setMemberHobby(chHob);
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 6. 회원 탈퇴
	/-------------------------------------------------------------------------------------------------*/
	public void removeAccount(Member member) {
		for(int i=0; i<memList.size(); i++) {
			if(memList.get(i).getMemberId().equals(member.getMemberId()))
				memList.remove(i);
		}
	}
	
}
