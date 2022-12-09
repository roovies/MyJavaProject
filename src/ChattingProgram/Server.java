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
		/ ���� ��ſ� �ʿ��� Ŭ���� ����
		/----------------------------------------------------------------------------------------------------*/
		ServerSocket serversocket = null;	// 1. �������� Ŭ����
		InputStream is = null; 				// 2. ����� ��Ʈ�� Ŭ���� 
		OutputStream os = null;				//    -> Input, Output ��Ʈ���� ����� ���� ��Ʈ���� ����� ���̹Ƿ� null�� ����.
		DataInputStream dis = null;			// 3. ����� ������Ʈ�� Ŭ����
		DataOutputStream dos = null; 		//    -> byte ����� �ƴ� ���ڷ� ����� ��Ʈ�� ������ ���� ������Ʈ���� DataStream ���
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("ä�� ������ ���� ���Դϴ�...");
			Thread.sleep(2000); 					// 2sec delay, [����ó�� �ʿ�]: InterruptedException
			/**----------------------------------------------------------------------------------------------------
			/ ���� ���� ���� �� Client ���� ����
			/----------------------------------------------------------------------------------------------------*/
			serversocket = new ServerSocket(PORT);	// �������� ����, [����ó�� �ʿ�]: IOException
			System.out.println("ä�� ������ �����Ͽ����ϴ�.");
			System.out.println("Ŭ���̾�Ʈ ���ӿ�û ��� ��...");
			Socket socket = serversocket.accept();	// ���(Listen)�ϴٰ� Client�� ���ӿ�û ��, Client�� ������ Socket ��ü�� ���� Return
			System.out.println("Ŭ���̾�Ʈ�� �����߽��ϴ�.");
			/**----------------------------------------------------------------------------------------------------
			/ ��Ʈ�� ��ü ����
			/----------------------------------------------------------------------------------------------------*/
			is = socket.getInputStream(); 			// Client�� �����ϴ� �����͸� �ۼ����ϱ� ���� ��Ʈ�� ��ü�� Socket���κ��� ����
			dis = new DataInputStream(is);
			os = socket.getOutputStream();			// ��, �ϳ��� ��Ʈ��(�������� ����� ��Ʈ��)�� ����Ͽ� �����͸� �ۼ���
			dos = new DataOutputStream(os);
			System.out.println("Ŭ���̾�Ʈ�� ä���� �����մϴ�. (���Ḧ ���ϸ� !���� �Է�)");
			while(true) {
				/*
				 * !!!�޽��� �ۼ��� ���� �߿�!!!
				 * Server�� ���� �޽��� ���� ��, Client���� ���ű���� ���� �ڵ��Ǿ�� ��. 
				 */
				/**----------------------------------------------------------------------------------------------------
				/ �޽��� ���۱�� (������Ʈ�� DataOutputStream ���)
				/----------------------------------------------------------------------------------------------------*/
				System.out.print("(��): ");
				String sendMsg = scan.nextLine();
				dos.writeUTF(sendMsg);
				if(sendMsg.equals("!����")) {
					System.out.println("������ ä���� �����Ͽ����ϴ�. ���α׷��� �����մϴ�.");
					break;
				}
				/**--------------------��--------------------------------------------------------------------------------
				/ �޽��� ���ű�� (������Ʈ�� DataIntputStream ���)
				/----------------------------------------------------------------------------------------------------*/
				String recvMsg = dis.readUTF();
				if(recvMsg.equals("!����")) {
					System.out.println("�����ʿ��� ä���� �����Ͽ����ϴ�. ���α׷��� �����մϴ�.");
					break;
				}
				System.out.println("Ŭ���̾�Ʈ(���): "+recvMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
