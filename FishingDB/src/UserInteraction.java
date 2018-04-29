import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class UserInteraction
{
	private String username, password, database, server, port;

	public void login()
	{
		//get login information
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your username: ");
		username = scan.nextLine();

		System.out.print("Enter your password: ");
		password = scan.nextLine();
		
		System.out.print("Enter your port (defualt port is 3306):  ");
		port = scan.nextLine();
		
		System.out.print("Enter your server(\"localhost\" is defualt): ");
		server = scan.nextLine();
		
		System.out.print("Enter database to connect: ");
		database = scan.nextLine();
		
	}

	public void askUser() throws SQLException
	{

		Scanner scan = new Scanner(System.in);
		
		Connect con = new Connect();
		
		String cmd = null;

		System.out.print("Get, Add, Remove, or Edit? (Enter 'done' to exit): ");
		cmd = scan.nextLine();

		cmd = cmd.toLowerCase();

		if (cmd.equals("done"))
		{
			execute.done = true;
		} 
		else if (cmd.equals("add"))
		{
			con.addSql();
		} 
		else if (cmd.equals("get"))
		{
			con.getSql();
		} 
		else if(cmd.equals("remove"))
		{
			con.removeSql();
		}
		else if (cmd.equals("edit"))
		{
			con.editSql();
		} else
		{
			System.out.println("Enter a valid command");
		}
		
		return;
	}
	
	//accessor methods
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public String getDatabase()
	{
		return database;
	}
	public String getPort()
	{
		return port;
	}
	public String getServer()
	{
		return server;
	}
}