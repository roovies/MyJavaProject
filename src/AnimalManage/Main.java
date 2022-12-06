package AnimalManage;

import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {
		//선언
		Function fn = new Function();
		//메뉴 화면 출력
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
					System.out.println("번호를 잘못 입력하셨습니다. 사용법 숙지 후 다시 시도해주세요.");
					break;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("문자는 입력할 수 없습니다. 사용법 숙지 후 다시 시도해주세요.");
				break;
			}
		}		
	}
}
