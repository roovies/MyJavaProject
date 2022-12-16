package MVC_Pattern;

import java.util.ArrayList;
import java.util.List;

public class MemberController {
	List<Member> memList; // ��ü ȸ�������� ������ �� (Database�� ���� ��)
	
	public MemberController() {
		memList = new ArrayList<Member>();	
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 1. ȸ������ ���
	/-------------------------------------------------------------------------------------------------*/
	public void joinMember(Member joinMember) {
		memList.add(joinMember); //ArrayList�� ���������� ����� Member ��ü �߰�
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 2. ��ü ȸ�� ��ȸ
	/-------------------------------------------------------------------------------------------------*/
	public List<Member> allMember() {
		// ��ü ȸ�������� ArrayList�� ����Ǿ� �����Ƿ�, memList�� ��ȯ.
		// memList�� �ڷ����� List<Member>�̹Ƿ� �޼ҵ� Ÿ���� List<Member>�� ����
		return memList; 
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 3, 5 ȸ�� ���̵� ���翩�� Ȯ��
	/-------------------------------------------------------------------------------------------------*/
	public Member searchId(String memberId) {
		for(int i=0; i<memList.size(); i++) {
			if(memList.get(i).getMemberId().equals(memberId)) //���޹��� member��ü�� id�� Member List�� �����ϴ��� Ȯ��
				return memList.get(i); //memberId�� �����ϴ� ��� �ش� member��ü ��ȯ
		}
		return null; //��ü�� ��ȯ�� ��, ��ü�� ���� ���(null)�� ��ȯ����� ��.
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 4. ȸ�� �̸� ���翩�� Ȯ��
	/-------------------------------------------------------------------------------------------------*/
	public Member searchName(String memberName) {
		for(int i=0; i<memList.size(); i++) {
			if(memList.get(i).getMemberName().equals(memberName))
				return memList.get(i);
		}
		return null;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 5. ȸ�� ���� ����
	/-------------------------------------------------------------------------------------------------*/
	public void changeId(Member member, String chId) {			// ���̵� ����
		member.setMemberId(chId);
	}
	public void changePw(Member member, String chPw) {			// �н����� ����
		member.setMemberPw(chPw);
	}
	public void changeName(Member member, String chName) {		// �̸� ����
		member.setMemberName(chName);
	}
	public void changeAge(Member member, int chAge) {			// ���� ����
		member.setMemberAge(chAge);
	}
	public void changeGender(Member member, String chGender) {	// ���� ����
		member.setMemberGender(chGender);
	}
	public void changeEmail(Member member, String chEmail) {	// �̸��� ����
		member.setMemberEmail(chEmail);
	}
	public void changePhone(Member member, String chPhone) {	// ��ȣ ����
		member.setMemberPhone(chPhone);
	}
	public void changeAddr(Member member, String chAddr) {		// �ּ� ����
		member.setMemberAddr(chAddr);
	}
	public void changeHobby(Member member, String chHob) {		// ��� ����
		member.setMemberHobby(chHob);
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 6. ȸ�� Ż��
	/-------------------------------------------------------------------------------------------------*/
	public void removeAccount(Member member) {
		for(int i=0; i<memList.size(); i++) {
			if(memList.get(i).getMemberId().equals(member.getMemberId()))
				memList.remove(i);
		}
	}
	
}
