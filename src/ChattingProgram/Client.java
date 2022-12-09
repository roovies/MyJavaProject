package ChattingProgram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		String ADDR = "127.0.0.1";
		int PORT = 8855;
		/**----------------------------------------------------------------------------------------------------/
		/ 소켓 통신에 필요한 클래스 선언
		/----------------------------------------------------------------------------------------------------*/
		Socket socket = null;				// 1. 서버소켓 클래스
		InputStream is = null; 				// 2. 입출력 스트림 클래스 
		OutputStream os = null;				//    -> Input, Output 스트림은 연결된 소켓 스트림을 사용할 것이므로 null로 선언.
		DataInputStream dis = null;			// 3. 입출력 보조스트림 클래스
		DataOutputStream dos = null; 		//    -> byte 기반이 아닌 문자로 입출력 스트림 구현을 위해 보조스트림인 DataStream 사용
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("서버에 연결 중입니다...");
			/**----------------------------------------------------------------------------------------------------/
			/ 클아이언트 소켓 생성 및 Server에 연결
			/----------------------------------------------------------------------------------------------------*/
			socket = new Socket(ADDR, PORT); 	// 클라이언트 소켓 생성 및 서버연결
			System.out.println("채팅 서버에 접속되었습니다.");
			/**----------------------------------------------------------------------------------------------------
			/ 스트림 객체 생성
			/----------------------------------------------------------------------------------------------------*/
			is = socket.getInputStream(); 			// Client가 전송하는 데이터를 송수신하기 위한 스트림 객체를 Socket으로부터 생성
			dis = new DataInputStream(is);
			os = socket.getOutputStream();			// 즉, 하나의 스트림(소켓으로 연결된 스트림)을 사용하여 데이터를 송수신
			dos = new DataOutputStream(os);
			System.out.println("서버와 채팅을 시작합니다. (종료를 원하면 !종료 입력)");
			while(true) {
				/*
				 * !!!메시지 송수신 순서 중요!!!
				 * Server가 먼저 메시지 전송 시, Client쪽은 수신기능이 먼저 코딩되어야 함. 
				 */
				/**----------------------------------------------------------------------------------------------------
				/ 메시지 수신기능 (보조스트림 DataIntputStream 사용)
				/----------------------------------------------------------------------------------------------------*/
				String recvMsg = dis.readUTF();
				if(recvMsg.equals("!종료")) {
					System.out.println("서버쪽에서 채팅을 종료하였습니다. 프로그램을 종료합니다.");
					break;
				}
				System.out.println("서버(상대): "+recvMsg);
				/**----------------------------------------------------------------------------------------------------
				/ 메시지 전송기능 (보조스트림 DataOutputStream 사용)
				/----------------------------------------------------------------------------------------------------*/
				System.out.print("(나): ");
				String sendMsg = scan.nextLine();
				dos.writeUTF(sendMsg);
				if(sendMsg.equals("!종료")) {
					System.out.println("클라이언트가 채팅을 종료하였습니다. 프로그램을 종료합니다.");
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
