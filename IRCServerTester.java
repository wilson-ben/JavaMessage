
public class IRCServerTester {
	public static void main(String[] args)
	{
		
		IRCServer server = new IRCServer("127.0.0.1", 6667);
		server.startServer();
		
		
		//server.run();
		
		//while(!(server.showMessage().equals("quit")))
		//{
		///	System.out.println(server.showMessage());
		//}
		
	}
}
