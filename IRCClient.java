/*Benjamin Wilson
 * Final project
 * AP Computer Science
 * 
 * Client Code
 * 
 */

import java.net.*;
import java.io.*;
import java.util.*; // imports for socket

public class IRCClient {
	static void sendMessage(BufferedWriter bw, String str) // send message code
	{
		try {
			bw.write(str + "\r\n"); // write to the socket connection
			bw.flush();
			
		}
		catch(Exception e) {
			System.out.println("Exception: "+e); // if there was an error in the command
		}
		
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner userInput = new Scanner(System.in); //collect user connection information
		String server = "";
		int port = 0;
		String nickname = "";
		
		
		System.out.print("Server name: ");
		server = userInput.next();
	
		System.out.print("\nPort Number: ");
		port = userInput.nextInt();
		
		System.out.print("\nNickname: ");
		nickname = userInput.next();
		String channel = "#main";
		
		
		
		
		boolean isEntering = true;
		do{
			System.out.print("\nirc> ");
			String message = userInput.next(); //collect user message
			if(message.contentEquals("quit"))
			{
				System.out.println("exiting...");
				isEntering = false;
			}
			else {
				Socket socket = new Socket(server,port);
				
				
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
				BufferedWriter bwriter = new BufferedWriter(outputStreamWriter);
				
				sendMessage(bwriter,"" + nickname + ": " + message);
				
			}
			
		}while(isEntering);
		
	}
	
}
