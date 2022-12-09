package ChattingProgram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		int PORT = 8855;
		/**----------------------------------------------------------------------------------------------------/
		/ 소켓 통신에 필요한 클래스 선언
		/----------------------------------------------------------------------------------------------------*/
		ServerSocket serversocket = null;	// 1. 서버소켓 클래스
		InputStream is = null; 				// 2. 입출력 스트림 클래스 
		OutputStream os = null;				//    -> Input, Output 스트림은 연결된 소켓 스트림을 사용할 것이므로 null로 선언.
		DataInputStream dis = null;			// 3. 입출력 보조스트림 클래스
		DataOutputStream dos = null; 		//    -> byte 기반이 아닌 문자로 입출력 스트림 구현을 위해 보조스트림인 DataStream 사용
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("채팅 서버를 구동 중입니다...");
			Thread.sleep(2000); 					// 2sec delay, [예외처리 필요]: InterruptedException
			/**----------------------------------------------------------------------------------------------------
			/ 서버 소켓 생성 및 Client 연결 수락
			/----------------------------------------------------------------------------------------------------*/
			serversocket = new ServerSocket(PORT);	// 서버소켓 생성, [예외처리 필요]: IOException
			System.out.println("채팅 서버를 구동하였습니다.");
			System.out.println("클라이언트 접속요청 대기 중...");
			Socket socket = serversocket.accept();	// 대기(Listen)하다가 Client의 접속요청 시, Client의 정보를 Socket 객체로 만들어서 Return
			System.out.println("클라이언트가 접속했습니다.");
			/**----------------------------------------------------------------------------------------------------
			/ 스트림 객체 생성
			/----------------------------------------------------------------------------------------------------*/
			is = socket.getInputStream(); 			// Client가 전송하는 데이터를 송수신하기 위한 스트림 객체를 Socket으로부터 생성
			dis = new DataInputStream(is);
			os = socket.getOutputStream();			// 즉, 하나의 스트림(소켓으로 연결된 스트림)을 사용하여 데이터를 송수신
			dos = new DataOutputStream(os);
			System.out.println("클라이언트와 채팅을 시작합니다. (종료를 원하면 !종료 입력)");
			while(true) {
				/*
				 * !!!메시지 송수신 순서 중요!!!
				 * Server가 먼저 메시지 전송 시, Client쪽은 수신기능이 먼저 코딩되어야 함. 
				 */
				/**----------------------------------------------------------------------------------------------------
				/ 메시지 전송기능 (보조스트림 DataOutputStream 사용)
				/----------------------------------------------------------------------------------------------------*/
				System.out.print("(나): ");
				String sendMsg = scan.nextLine();
				dos.writeUTF(sendMsg);
				if(sendMsg.equals("!종료")) {
					System.out.println("서버가 채팅을 종료하였습니다. 프로그램을 종료합니다.");
					break;
				}
				/**--------------------ㅌ--------------------------------------------------------------------------------
				/ 메시지 수신기능 (보조스트림 DataIntputStream 사용)
				/----------------------------------------------------------------------------------------------------*/
				String recvMsg = dis.readUTF();
				if(recvMsg.equals("!종료")) {
					System.out.println("서버쪽에서 채팅을 종료하였습니다. 프로그램을 종료합니다.");
					break;
				}
				System.out.println("클라이언트(상대): "+recvMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
