package AnimalManage;

import java.util.Scanner;

public class Function {
	Scanner scan = new Scanner(System.in);
	int cnt = 0;
	Information[] info = new Information[5];
	//메뉴화면
	public int printmenu() {
		System.out.println("===== 애완동물 관리 프로그램 =====");
		System.out.println("1. 애완동물 정보 입력");
		System.out.println("2. 애완동물 상태 체크");
		System.out.println("3. 병원 예약");
		System.out.println("4. 병원 예약 확인 및 상태 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("===============================");
		System.out.print("입력: ");
		int choice = scan.nextInt();
		return choice;
	}
	//정보입력
	public void input_info() {
		while(true) {
			if(cnt==5) {
				System.out.println("******************************");
				System.out.println("*  최대 5개가 입력됐습니다.  *\n*  초기화면으로 돌아갑니다.  *");
				System.out.println("******************************");
				break;
			}
			System.out.println("===== 애완동물 정보 입력 =====");
			System.out.println("===== 최대 "+(cnt+1)+"/5개 입력 가능=====");
			System.out.print("1. 종을 입력하세요 (ex)고양이: ");
			String species = scan.next();
			System.out.print("2. 품종을 입력하세요 (ex)말티즈: ");
			String breed = scan.next();
			System.out.print("3. 이름을 입력하세요: ");
			String name = scan.next();
			System.out.print("3. 성별을 입력하세요(M/F): ");
			char gender = scan.next().charAt(0);
			System.out.print("4. 나이를 입력하세요(숫자만): ");
			int age = scan.nextInt();
			System.out.print("5. 입양일을 입력하세요 (ex)210509: ");
			int date = scan.nextInt();
			info[cnt] = new Information(species, breed, name, gender, age, date);
			cnt++;
		}
	}
	//정보조회
	public void check_info() {
		System.out.println("===== 애완동물 정보 출력 =====");
		System.out.print("1. 이름을 입력하세요: ");
		String name = scan.next();
		System.out.print("2. 입양일을 입력하세요 (ex)210509: ");
		int date = scan.nextInt();
		for(int i=0; i<5; i++) {
			if(name==info[i].getName(name) | date==info[i].getDate(date)) {
				System.out.println("[이름] "+info[i].getName(name));
				System.out.println("[종] "+info[i].getSpecies()+"  |  [품종] "+info[i].getBreed());
				System.out.println("[성별] "+info[i].getGender());
				System.out.println("[나이] "+info[i].getAge());
				System.out.println("[입양일] "+info[i].getDate(date));
			}
		}
		System.out.println("***************************");
		System.out.println("*  조회가 완료됐습니다.   *\n*  초기화면으로 돌아갑니다*");
		System.out.println("***************************");
	}
	
	//병원 예약
	public void reserv_hosp() {
		System.out.println("===== 애완동물 병원 예약 =====");
		System.out.print("1. 이름을 입력하세요: ");
		String name = scan.next();
		System.out.print("2. 입양일을 입력하세요 (ex)210509: ");
		int date = scan.nextInt();
		System.out.print("3. 애완동물의 현재 상태 입력하세요: ");
		String condition = scan.next();
		System.out.println("4. 예약 날짜를 입력하세요 (ex)210509: ");
		int reserv = scan.nextInt();
		for(int i=0; i<5; i++) {
			if(name==info[i].getName(name) | date==info[i].getDate(date)) {
				info[i].setReserv(reserv);
				info[i].setCondition(condition);
			}
		}
		System.out.println("***************************");
		System.out.println("*  예약이 완료됐습니다.   *\n*  초기화면으로 돌아갑니다*");
		System.out.println("***************************");
	}
	
	//병원예약 및 상태 조회
	public void check_hosp() {
		System.out.println("===== 병원예약 및 상태 조회 =====");
		System.out.print("1. 이름을 입력하세요: ");
		String name = scan.next();
		System.out.print("2. 입양일을 입력하세요 (ex)210509: ");
		int date = scan.nextInt();
		for(int i=0; i<5; i++) {
			if(name==info[i].getName(name) | date==info[i].getDate(date)) {
				System.out.println("[이름] "+info[i].getName(name));
				System.out.println("[예약일] "+info[i].getReserv());
				System.out.println("[현재 상태] "+info[i].getCondition());
			}
		}
		System.out.println("***************************");
		System.out.println("*  조회가 완료됐습니다.   *\n*  초기화면으로 돌아갑니다*");
		System.out.println("***************************");
	}
	
	//종료 메시지
	public void close_msg() {
		System.out.println("프로그램을 종료합니다. 감사합니다.");
	}
}
