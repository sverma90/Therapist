import java.io.*;
import java.net.*;

public class ServerAcceptsConnections 
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(2222);					//tell ss to listen to port 2222
		Socket socket = ss.accept();								//wait for a client to CALL (connect to port 2222)
		System.out.println("Connection accepted from a client");
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String message = dis.readUTF();								// wait for client to send
		System.out.println("Received message: " + message);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("I am fine, thank you");		//(YOU ARE SENDING THIS MESSAGE FROM SERVER TO CLIENT
		dos.close();												//hang up! (terminate the connection)
	}

}
	/*FOR QUIZ PRACTICE:
	 * 
	 * YOu need lines 10, 11, 12, 16, 17
	 * I am the client and instructor is the server
	 * I need # or value from instructor (server)
	 */
	