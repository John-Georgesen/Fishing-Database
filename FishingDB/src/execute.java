import java.sql.SQLException;
import java.util.Scanner;

public class execute 
{
	public static boolean done = false;
	
	//the user interacting object that all the classes use
	public static UserInteraction inter = new UserInteraction();
	
	public static void main(String[] args) throws SQLException
	{
		boolean done = false;
		
		String response = null;
		
		//login the user
		inter.login();
		
		//connect to the database
		Connect con = new Connect();
		System.out.println("Successfully Connected!");

		Scanner scan = new Scanner(System.in);
		
		//create a looping command line
		do
		{
			System.out.print("Would you like to continue (yes of no)?: ");
			response = scan.nextLine();
			
			response = response.toLowerCase();
			
			if(response.equals("yes"))
			{
				//ask user (edit,add,remove, or get)
				inter.askUser();
				
			}
			//if user declines offer to continue
			else if(response.equals("no"))
			{
				System.out.println("Exiting...");
				
				//break from the loop
				done = true;
			}
			else
			{
				System.out.println("Enter a valid command");
			}
		}
		while(done != true);
	}
}