import java.net.*;

import java.io.*;
import java.util.*;



public class IRCServer {
	private String hostAddress;
	private static int portAddress = 0;;
	//private String message = "";
	
	// Vector to store active clients 
    
    static int i = 0;
    static String message = "";
	public IRCServer(String host, int port)
	{
		hostAddress = host;
		portAddress = port;
		
		
		
	}
	public static void startServer()
	{
		boolean listening = true;
		try {
			
				
			
			
			ServerSocket server = new ServerSocket(portAddress);
			System.out.println("Server Started");
			acceptConnection(server);
		}
			
		catch(IOException e)
		{
			//System.out.println(i);
		}
		
	
	} 
	public static void acceptConnection(ServerSocket server)
	{
		try {
	
		Socket socket = server.accept();
		
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		
		
		
   	 	inputMethod(dis, server, socket);
		
	} catch(IOException e)
		{
		//System.out.println(i);
	}
	
	}
		
		
	
	public static void inputMethod(DataInputStream dis, ServerSocket server, Socket socket) {
		Scanner s = new Scanner(dis);
		
		try {
		
			// if the recipient is found, write on its 
            // output stream 
       	 
       	 System.out.println(s.nextLine());
       	 s.close();
       	 socket.close();
       	 acceptConnection(server);
		} catch(IOException e)
		{
		//System.out.println(i);
	}
	
       	 
		
		
	}
	
	public IRCServer()
	{
		hostAddress = "";
		portAddress = 0;
	}
	
	public String showMessage()
	{
		return "" + message;
		
	}

}
/*
//ClientHandler class 
class ClientHandler implements Runnable  
{ 
 Scanner scn = new Scanner(System.in); 
 public String name; 
 final DataInputStream dis; 
 final DataOutputStream dos; 
 Socket s; 
 boolean isloggedin; 
   
 // constructor 
 public ClientHandler(Socket s, String name, 
                         DataInputStream dis, DataOutputStream dos) { 
     this.dis = dis; 
     this.dos = dos; 
     this.name = name; 
     this.s = s; 
     this.isloggedin=true; 
     run();
 } 
 
 @Override
 public void run() {
 

      
     try {
     
    	 
             
        	 
        	 
         
     } catch(NoSuchElementException e) {
    	 e.printStackTrace();
     }
     
      
     
	 /*try {
		this.dis.close();
		this.dos.close(); 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} */
     
    // while (!(clientMessage.equals("exit")))  
    // { 
        
         
        	 
        	 //String message = dis.readUTF();
        	 
        	 //System.out.println(message);
       
             /*
             
             // receive the string 
             received = dis.readUTF(); 
               
             System.out.println(received); 
               
             if(received.equals("logout")){ 
                 this.isloggedin=false; 
                 this.s.close(); 
                 break; 
             } 
               
             // break the string into message and recipient part 
             StringTokenizer st = new StringTokenizer(received, "#"); 
             String MsgToSend = st.nextToken(); 
             String recipient = st.nextToken(); 

             // search for the recipient in the connected devices list. 
             // ar is the vector storing client of active users 
             for (ClientHandler mc : IRCServer.ar)  
             { 
                 // if the recipient is found, write on its 
                 // output stream 
                 if (mc.name.equals(recipient) && mc.isloggedin==true)  
                 { 
                     mc.dos.writeUTF(this.name+" : "+MsgToSend); 
                     break; 
                 } 
             } 
             /*
         
 
    // } /*
 
     try
     { 
         // closing resources 
    	 
         this.dis.close(); 
         this.dos.close(); 
           
     }
     catch(IOException e){ 
         e.printStackTrace(); 
     }
 
}

	*/
