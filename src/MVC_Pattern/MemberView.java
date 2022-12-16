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
	/ 0. ����ȭ�� ���
	/-------------------------------------------------------------------------------------------------*/
	public int mainPrint() {
		System.out.println("========== ȸ������ ���α׷� =====");
		System.out.println("==\t1. ȸ�� ����\t\t==");
		System.out.println("==\t2. ��ü ȸ�� ��ȸ\t==");
		System.out.println("==\t3. ȸ�� ���̵�� ��ȸ\t==");
		System.out.println("==\t4. ȸ�� �̸����� ��ȸ\t==");
		System.out.println("==\t5. ȸ�� ���� ����\t==");
		System.out.println("==\t6. ȸ�� Ż��\t\t==");
		System.out.println("==\t0. ���α׷� ����\t==");
		System.out.println("==================================");
		System.out.print("�޴� �Է�: ");
		int input = sc.nextInt();
		return input;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 1. ȸ������ ȭ�� ���
	/-------------------------------------------------------------------------------------------------*/
	public Member joinPrint() {
		Member member = null;
		while(true) {
			try {
				System.out.println("============= �Է� ===============");
				System.out.print("1. ���̵� �Է�: ");
				String memberId = sc.next();
				System.out.print("2. �н����� �Է�: ");
				String memberPw = sc.next();
				System.out.print("3. �̸� �Է�: ");
				String memberName = sc.next();
				System.out.print("4. ���� �Է�: ");
				int memberAge = sc.nextInt();
				System.out.print("5. ���� �Է�: ");
				String memberGender = sc.next();
				System.out.print("6. �̸��� �Է�: ");
				String memberEmail = sc.next();
				System.out.print("7. ��ȣ �Է�: ");
				String memberPhone = sc.next();
				System.out.print("8. �ּ� �Է�: ");
				sc.nextLine();
				String memberAddr = sc.nextLine();
				System.out.print("9. ��� �Է�: ");
				String memberHobby = sc.next();
				System.out.println("==================================");
				//�Էµ� ������ Member ��ü ���� �� return
				member = new Member(memberId, memberPw, memberName, memberAge, memberGender, memberEmail, memberPhone, memberAddr, memberHobby);
				return member;
			}catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է��� �� �����ϴ�. ���ڸ� �Է����ּ���.");
				sc.nextLine();
				continue;
			} 
		}
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 2. ��ü ȸ�� ��ȸ ȭ�� ���
	/-------------------------------------------------------------------------------------------------*/
	public void allPrint(List<Member> memList) {
		for(int i=0; i<memList.size(); i++) {
			Member member = memList.get(i);
			System.out.println(member.information(member));
		}
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 3. ���̵� �˻� ȭ�� ���
	/-------------------------------------------------------------------------------------------------*/
	// (1). ���̵� �Է� ȭ��  --> ���̵� �Է� ����� [5. ȸ������ ����] �� [6. ȸ��Ż��] ��ɿ��� ����
	public String idSearch_Print() {
		System.out.println("==================================");
		System.out.print("���̵� �Է�:");
		String memberId = sc.next();
		return memberId;
	}
	// (2). ȸ�� ���̵�� ��ȸ ��� ȭ�� ���
	public void idResult_Print(Member member, String memberId) {
		if(member==null) 
			System.out.println(memberId+"��(��) �������� �ʴ� ȸ���Դϴ�.");
		else
			System.out.println(member.information(member));
		System.out.println("==================================");
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 4. �̸� �˻�ȭ�� ���
	/-------------------------------------------------------------------------------------------------*/
	// (1). �̸� �Է� ȭ�� ���
	public String nameSearch_Pirnt() {
		System.out.println("==================================");
		System.out.print("�̸� �Է�:");
		String memberName = sc.next();
		return memberName;
	}
	// (2). �̸� �˻� ��� ȭ�� ���
	public void nameResult_Print(Member member, String memberName) {
		if(member==null)
			System.out.println("�̸���"+memberName+"�� ȸ���� �������� �ʽ��ϴ�.");
		else
			System.out.println(member.information(member));
		System.out.println("==================================");
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 5. ȸ�� ���� ���� ȭ�� ���
	/-------------------------------------------------------------------------------------------------*/
	// (1). ���̵� ���翩�ο� ���� ������ �׸� ���� ȭ�� ���
	// �̷� if���� main���� ó���ϰ�, �޼ҵ带 �и��ϴ� �� �� �������� ���� �� ����. (��, ����ؾ� �Ǵ� �޼ҵ�� ������)
	// ������ȯ �޼ҵ�, ������ȯ �޼ҵ带 �����صθ� ���� ��.
	public int changeChoice_Print(Member member, String memberId) {
		while(true) {
			try {
				if(member==null) {
			System.out.println(memberId+"��(��) �������� �ʴ� ȸ���Դϴ�.");
			System.out.println("==================================");
			return 0;
			}	
			else {
				System.out.println(memberId+"�� ������ ������ �������ּ���.");
				System.out.println("> 1. ���̵�");
				System.out.println("> 2. �н�����");
				System.out.println("> 3. �̸�");
				System.out.println("> 4. ����");
				System.out.println("> 5. ����");
				System.out.println("> 6. �̸���");
				System.out.println("> 7. ��ȣ");
				System.out.println("> 8. �ּ�");
				System.out.println("> 9. ���");
				System.out.println("==================================");
				System.out.print("����: ");
				int choice = sc.nextInt();
				return choice;
			}
			}catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է��� �� �����ϴ�. ���ڸ� �Է����ּ���.");
				System.out.println("==================================");
				sc.nextLine();
				continue;
			}
		}
		
	}
	// (2). ������ ���� ���� ȭ�� ���
	public String change_Print(String category) { 				//String Ÿ�� �׸� ����ȭ��
		System.out.print("������ "+category+" �Է�: ");
		String content = sc.next();
		return content;
	}
	
	public int change_Print2(String category) { 				//int Ÿ�� �׸� ����ȭ��
		while(true) {
			try {
				System.out.print("������ "+category+" �Է�: ");
				int content = sc.nextInt();
				return content;
			}catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է��� �� �����ϴ�. ���ڸ� �Է����ּ���.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 6. ȸ�� Ż�� Ȯ�� ȭ��
	/-------------------------------------------------------------------------------------------------*/
	public String checkRemove_Print(Member member, String id) {
		if(member==null) {
			System.out.println(id+"��(��) �������� �ʴ� ȸ���Դϴ�.");
			System.out.println("==================================");
			return "X";
		}
		else {
			System.out.println("���� ["+id+"] ������ �����Ͻðڽ��ϱ�? (Y/N)");
			System.out.print(">> ");
			String choice = sc.next();
			return choice;
		}
	}
	public void successRemove_Print(String id) {
		System.out.println("["+id+"] ������ ���������� �����߽��ϴ�.");
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 0. ��Ÿ �޽��� ���
	/-------------------------------------------------------------------------------------------------*/
	public void displayBye() { //����޽���
		System.out.println("@@ ���α׷��� �����մϴ�. @@");
	}
	
	public void displayError() { //�����޽���
		System.out.println("�� �߸��� �Է� �Ǵ� �����Դϴ�. �ٽ� ���������� �õ����ּ���.");
	}
	
}
