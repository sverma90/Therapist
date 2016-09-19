import java.io.*;
import java.net.*;

public class TherapistServer 
{
	static String[] reply = { 
            "It's OK with me",
            "Your guess is as good as mine",
            "What would your Dad say about that?",
            "It's unlikely",
            "Probably sooner or later",
            "That's for you to decide",
            "Not today!",
            "Absolutely!", 
            "Ask your Mother",
            "In your dreams",
            "It's not looking good...",
            "I don't think so.",
            "Are you kidding?",
            "Not in this lifetime!",
            "That would be swell",
            "Why not?",
            "Yes.",
            "No."};
	
	public static void main(String[] args) throws IOException
	{
		String serverAddress = "localhost";
		int serverPort = 2222;
		
		//In the starter code, there should already be a declaration of a ServerSocket called ss.
		ServerSocket ss = new ServerSocket(2222);//tell ss to listen to port 2222
		
		if(args.length>1)
		{
			System.out.println("ERROR, command line parameter are not accepted by TherapistServer.");
		}
		
		System.out.println("serverAddress " + serverAddress + " serverPort " + serverPort);
		
		while(true) // do forever
        {
        try {
        	// all of the code for this client
        	Socket s = ss.accept(); // wait for client to call, create a Socket by calling the accept() method on the ServerSocket. 
            DataInputStream dis = new DataInputStream(s.getInputStream());		// d i s = data input stream, create a DataInputStream for the Socket. 
    		String question = dis.readUTF();				//Assign the received message to a String called question, wait for client to send, do a readUTF() on the dis 
    		DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
            String answer = reply[(int)(Math.random() * reply.length)];  		//Randomly create an index to use to access the replies array. 
            dos.writeUTF(answer);
            if (question.equals("test"))
            {
            	System.out.println("test connect from client successful.");
            }
            else
            {
                System.out.println("A patient asks: " + question + " and the answer is: " + answer); // trace
            }
            dos.close(); // Call close() on the Socket or the DataInputStream or the DataOutputStream. Any of these will "hang up the phone" from the server side. 
            }  
        catch (IOException e)
            {
            System.out.println(e); 
            }
        }  
		
	}

}



/*
//TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(2222);					//tell ss to listen to port 2222
		Socket socket = ss.accept();								//wait for a client to CALL (connect to port 2222)
		System.out.println("Connection accepted from a client");
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String message = dis.readUTF();								// wait for client to send
		System.out.println("Received message: " + message);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("I am fine, thank you");
		dos.close();												//hang up! (terminate the connection)

*/