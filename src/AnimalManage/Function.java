package AnimalManage;

import java.util.Scanner;

public class Function {
	Scanner scan = new Scanner(System.in);
	int cnt = 0;
	Information[] info = new Information[5];
	//�޴�ȭ��
	public int printmenu() {
		System.out.println("===== �ֿϵ��� ���� ���α׷� =====");
		System.out.println("1. �ֿϵ��� ���� �Է�");
		System.out.println("2. �ֿϵ��� ���� üũ");
		System.out.println("3. ���� ����");
		System.out.println("4. ���� ���� Ȯ�� �� ���� ��ȸ");
		System.out.println("5. ���α׷� ����");
		System.out.println("===============================");
		System.out.print("�Է�: ");
		int choice = scan.nextInt();
		return choice;
	}
	//�����Է�
	public void input_info() {
		while(true) {
			if(cnt==5) {
				System.out.println("******************************");
				System.out.println("*  �ִ� 5���� �Էµƽ��ϴ�.  *\n*  �ʱ�ȭ������ ���ư��ϴ�.  *");
				System.out.println("******************************");
				break;
			}
			System.out.println("===== �ֿϵ��� ���� �Է� =====");
			System.out.println("===== �ִ� "+(cnt+1)+"/5�� �Է� ����=====");
			System.out.print("1. ���� �Է��ϼ��� (ex)�����: ");
			String species = scan.next();
			System.out.print("2. ǰ���� �Է��ϼ��� (ex)��Ƽ��: ");
			String breed = scan.next();
			System.out.print("3. �̸��� �Է��ϼ���: ");
			String name = scan.next();
			System.out.print("3. ������ �Է��ϼ���(M/F): ");
			char gender = scan.next().charAt(0);
			System.out.print("4. ���̸� �Է��ϼ���(���ڸ�): ");
			int age = scan.nextInt();
			System.out.print("5. �Ծ����� �Է��ϼ��� (ex)210509: ");
			int date = scan.nextInt();
			info[cnt] = new Information(species, breed, name, gender, age, date);
			cnt++;
		}
	}
	//������ȸ
	public void check_info() {
		System.out.println("===== �ֿϵ��� ���� ��� =====");
		System.out.print("1. �̸��� �Է��ϼ���: ");
		String name = scan.next();
		System.out.print("2. �Ծ����� �Է��ϼ��� (ex)210509: ");
		int date = scan.nextInt();
		for(int i=0; i<5; i++) {
			if(name==info[i].getName(name) | date==info[i].getDate(date)) {
				System.out.println("[�̸�] "+info[i].getName(name));
				System.out.println("[��] "+info[i].getSpecies()+"  |  [ǰ��] "+info[i].getBreed());
				System.out.println("[����] "+info[i].getGender());
				System.out.println("[����] "+info[i].getAge());
				System.out.println("[�Ծ���] "+info[i].getDate(date));
			}
		}
		System.out.println("***************************");
		System.out.println("*  ��ȸ�� �Ϸ�ƽ��ϴ�.   *\n*  �ʱ�ȭ������ ���ư��ϴ�*");
		System.out.println("***************************");
	}
	
	//���� ����
	public void reserv_hosp() {
		System.out.println("===== �ֿϵ��� ���� ���� =====");
		System.out.print("1. �̸��� �Է��ϼ���: ");
		String name = scan.next();
		System.out.print("2. �Ծ����� �Է��ϼ��� (ex)210509: ");
		int date = scan.nextInt();
		System.out.print("3. �ֿϵ����� ���� ���� �Է��ϼ���: ");
		String condition = scan.next();
		System.out.println("4. ���� ��¥�� �Է��ϼ��� (ex)210509: ");
		int reserv = scan.nextInt();
		for(int i=0; i<5; i++) {
			if(name==info[i].getName(name) | date==info[i].getDate(date)) {
				info[i].setReserv(reserv);
				info[i].setCondition(condition);
			}
		}
		System.out.println("***************************");
		System.out.println("*  ������ �Ϸ�ƽ��ϴ�.   *\n*  �ʱ�ȭ������ ���ư��ϴ�*");
		System.out.println("***************************");
	}
	
	//�������� �� ���� ��ȸ
	public void check_hosp() {
		System.out.println("===== �������� �� ���� ��ȸ =====");
		System.out.print("1. �̸��� �Է��ϼ���: ");
		String name = scan.next();
		System.out.print("2. �Ծ����� �Է��ϼ��� (ex)210509: ");
		int date = scan.nextInt();
		for(int i=0; i<5; i++) {
			if(name==info[i].getName(name) | date==info[i].getDate(date)) {
				System.out.println("[�̸�] "+info[i].getName(name));
				System.out.println("[������] "+info[i].getReserv());
				System.out.println("[���� ����] "+info[i].getCondition());
			}
		}
		System.out.println("***************************");
		System.out.println("*  ��ȸ�� �Ϸ�ƽ��ϴ�.   *\n*  �ʱ�ȭ������ ���ư��ϴ�*");
		System.out.println("***************************");
	}
	
	//���� �޽���
	public void close_msg() {
		System.out.println("���α׷��� �����մϴ�. �����մϴ�.");
	}
}
