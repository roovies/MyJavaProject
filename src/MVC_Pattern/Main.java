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
			case 1: // ȸ�� ����
				Member joinMember = memView.joinPrint();
				memCon.joinMember(joinMember);
				break;
			case 2: // ��ü ȸ�� ��ȸ
				List<Member> memList = memCon.allMember(); // return�޴� �����Ͱ� List<Member> �ڷ���
				memView.allPrint(memList);
				break;
			case 3: // ȸ�� ���̵�� ��ȸ
				String inputId = memView.idSearch_Print();
				Member searchMember = memCon.searchId(inputId);
				memView.idResult_Print(searchMember, inputId);
				break;
			case 4: // ȸ�� �̸����� ��ȸ
				String inputName = memView.nameSearch_Pirnt();
				Member searchMember2 = memCon.searchName(inputName);
				memView.nameResult_Print(searchMember2, inputName);
				break;
			case 5: // ȸ�� ���� ����
				// ȸ�� ������ �����ϱ� ���� ���̵� �Է¹ް� �Ǵ�
				String inputId2 = memView.idSearch_Print();
				Member searchMember3 = memCon.searchId(inputId2);
				int choiceinfo = memView.changeChoice_Print(searchMember3, inputId2);
				if(choiceinfo==1) {
					String content = memView.change_Print("���̵�");
					memCon.changeId(searchMember3, content);
				}
				else if(choiceinfo==2) {
					String content = memView.change_Print("�н�����");
					memCon.changePw(searchMember3, content);
				}
				else if(choiceinfo==3) {
					String content = memView.change_Print("�̸�");
					memCon.changeName(searchMember3, content);
				}
				else if(choiceinfo==4) {
					int content = memView.change_Print2("����");
					memCon.changeAge(searchMember3, content);
				}
				else if(choiceinfo==5) {
					String content = memView.change_Print("����");
					memCon.changeGender(searchMember3, content);
				}
				else if(choiceinfo==6) {
					String content = memView.change_Print("�̸���");
					memCon.changeEmail(searchMember3, content);
				}
				else if(choiceinfo==7) {
					String content = memView.change_Print("��ȣ");
					memCon.changePhone(searchMember3, content);
				}
				else if(choiceinfo==8) {
					String content = memView.change_Print("�ּ�");
					memCon.changeAddr(searchMember3, content);
				}
				else if(choiceinfo==9) {
					String content = memView.change_Print("���");
					memCon.changeHobby(searchMember3, content);
				}
				else if(choiceinfo==0) 
					break;
				else
					memView.displayError();
				break;
			case 6: // ȸ�� Ż��
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
