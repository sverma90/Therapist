import java.io.*;
import java.net.*;


public class ClientInitiatesConnection
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost",2222);
		System.out.println("Connection made to app at port 2222, this computer.");
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("How are you today?");		// U n i code Transmission Format (YOU ARE SENDING THIS MESSAGE FROM CLIENT TO SERVER)
		DataInputStream dis = new DataInputStream(socket.getInputStream());		// d i s = data input stream
		String reply = dis.readUTF(); 								// wait for server to send
		System.out.println("Received reply from server: " + reply);		
	}

}

	/*	For quiz practice
	 * 	you need lines 11, 12, 15, 16, 17
	 * 	I am the client and instructor is the server
	 * 	I need # or value from instructor (server)
	 */
