import java.io.*;
import java.net.*;
import java.util.*;


public class TherapistClient
{

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		// TODO Auto-generated method stub
		
		String serverAddress = "localhost";
		int serverPort = 2222;		
		
		if(args.length==1)
		{
			serverAddress = args[0];
		}
		
		if(args.length==2)
		{
			if(args[1].length() != 4)
			{
				//If the parseInt() method determines that the characters in the String parameter (args[1]) are not numeric, it throws NumberFormatException. So we can simply catch that and, in the catch block, issue our error message!
				try 
				{
					serverPort = Integer.parseInt(args[1]);		//converts string to an int
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("specified port number is not numeric");
					return;
				}
				
				if(serverPort < 1000)
				{
					System.out.println("ERROR, serverPort must be over 1000 to proceed.");
					return;
				}
				System.out.println("ERROR, invalid serverPort");
				return;
			}
			
		}
		if(args.length > 2)
		{
			System.out.println("ERROR");
			System.out.println("Restart. Server address may optionally be provided " + "in dotted-numeric form as the first cmd line parameter.");
			System.out.println("Server port number may optionally be provided " + "as a second command line parameter.");
			System.out.println("More than two parameters are not accepted.");
			return;
		}
		
		System.out.println("Welcome To Online Therapy!");
		System.out.println("Enter EXIT at any time to terminate your session.");
		System.out.println("You may now enter a question to be answered by the therapist.");
		System.out.println("(For brevity, please phrase your question such that it can be answered with a YES or NO reply. e.g. Will I feel better soon?)");

		
		//SEE KEYBOARD TO DISK PROGRAM
		InputStreamReader isr = new InputStreamReader(System.in);	
		BufferedReader    br  = new BufferedReader(isr);
		FileWriter        fw  = new FileWriter("TherapistLog.txt");		//open output file
		BufferedWriter    bw  = new BufferedWriter(fw);
		bw.write("Log of therapy session on " + new Date());
		
		while(true)
		{
			String question = br.readLine();	// read keyboard when operator hits ENTER
			if (question.equalsIgnoreCase("exit")) break;	//see if the question is "exit". If so, break out of the loop. 
            Socket socket = new Socket(serverAddress, serverPort);	//if not, establish a connection to the server 
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());	//then send the question to the server. 
			dos.writeUTF("How are you today?");		// U n i code Transmission Format
			DataInputStream dis = new DataInputStream(socket.getInputStream());		// d i s = data input stream
			String answer = dis.readUTF(); 								// wait for server to send / receive (wait for) an answer from the server. 
            System.out.println("Received answer from server: "+ answer);
			String logLine = "Question: " + question + " Answer: " + answer;			
			bw.write(question);// write this String to file
			bw.newLine(); // add new line char
		}
		String logLine = "The session has ended";
	}

}
