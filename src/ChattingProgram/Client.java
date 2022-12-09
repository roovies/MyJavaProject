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
		/ ���� ��ſ� �ʿ��� Ŭ���� ����
		/----------------------------------------------------------------------------------------------------*/
		Socket socket = null;				// 1. �������� Ŭ����
		InputStream is = null; 				// 2. ����� ��Ʈ�� Ŭ���� 
		OutputStream os = null;				//    -> Input, Output ��Ʈ���� ����� ���� ��Ʈ���� ����� ���̹Ƿ� null�� ����.
		DataInputStream dis = null;			// 3. ����� ������Ʈ�� Ŭ����
		DataOutputStream dos = null; 		//    -> byte ����� �ƴ� ���ڷ� ����� ��Ʈ�� ������ ���� ������Ʈ���� DataStream ���
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("������ ���� ���Դϴ�...");
			/**----------------------------------------------------------------------------------------------------/
			/ Ŭ���̾�Ʈ ���� ���� �� Server�� ����
			/----------------------------------------------------------------------------------------------------*/
			socket = new Socket(ADDR, PORT); 	// Ŭ���̾�Ʈ ���� ���� �� ��������
			System.out.println("ä�� ������ ���ӵǾ����ϴ�.");
			/**----------------------------------------------------------------------------------------------------
			/ ��Ʈ�� ��ü ����
			/----------------------------------------------------------------------------------------------------*/
			is = socket.getInputStream(); 			// Client�� �����ϴ� �����͸� �ۼ����ϱ� ���� ��Ʈ�� ��ü�� Socket���κ��� ����
			dis = new DataInputStream(is);
			os = socket.getOutputStream();			// ��, �ϳ��� ��Ʈ��(�������� ����� ��Ʈ��)�� ����Ͽ� �����͸� �ۼ���
			dos = new DataOutputStream(os);
			System.out.println("������ ä���� �����մϴ�. (���Ḧ ���ϸ� !���� �Է�)");
			while(true) {
				/*
				 * !!!�޽��� �ۼ��� ���� �߿�!!!
				 * Server�� ���� �޽��� ���� ��, Client���� ���ű���� ���� �ڵ��Ǿ�� ��. 
				 */
				/**----------------------------------------------------------------------------------------------------
				/ �޽��� ���ű�� (������Ʈ�� DataIntputStream ���)
				/----------------------------------------------------------------------------------------------------*/
				String recvMsg = dis.readUTF();
				if(recvMsg.equals("!����")) {
					System.out.println("�����ʿ��� ä���� �����Ͽ����ϴ�. ���α׷��� �����մϴ�.");
					break;
				}
				System.out.println("����(���): "+recvMsg);
				/**----------------------------------------------------------------------------------------------------
				/ �޽��� ���۱�� (������Ʈ�� DataOutputStream ���)
				/----------------------------------------------------------------------------------------------------*/
				System.out.print("(��): ");
				String sendMsg = scan.nextLine();
				dos.writeUTF(sendMsg);
				if(sendMsg.equals("!����")) {
					System.out.println("Ŭ���̾�Ʈ�� ä���� �����Ͽ����ϴ�. ���α׷��� �����մϴ�.");
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
