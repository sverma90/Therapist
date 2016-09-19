import java.io.*;

public class KeyboardToDisk {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader    br  = new BufferedReader(isr);
		FileWriter        fw  = new FileWriter("LogFile.txt");
		BufferedWriter    bw  = new BufferedWriter(fw);
		System.out.println("Enter input for log.");
		
		while(true)
		{
			String input = br.readLine(); 				//read keyboard when operator hits ENTER
			bw.write(input); 							// write this String to file
			bw.newLine();								// add new line char
		}
		
	}

}
