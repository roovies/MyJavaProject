package AnimalManage;

import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {
		//����
		Function fn = new Function();
		//�޴� ȭ�� ���
		while(true) {
			try {
				int choice = fn.printmenu();
				if(choice==1) {
					fn.input_info();
				}
				else if(choice==2) {
					fn.check_info();
				}
				else if(choice==3) {
					fn.reserv_hosp();
				}
				else if(choice==4) {
					fn.check_hosp();
				}
				else if(choice==5) {
					fn.close_msg();
					break;
				}
				else {
					System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. ���� ���� �� �ٽ� �õ����ּ���.");
					break;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("���ڴ� �Է��� �� �����ϴ�. ���� ���� �� �ٽ� �õ����ּ���.");
				break;
			}
		}		
	}
}
