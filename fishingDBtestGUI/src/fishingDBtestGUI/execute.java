package fishingDBtestGUI;
import java.sql.SQLException;
import java.util.Scanner;

public class execute 
{
	public static boolean done = false;
	
	public static void main(String[] args) throws SQLException
	{
		//create login screen
		loginGUI loginScreen = new loginGUI();
		
		loginScreen.createGUI();
		
		loginScreen.mainFrame.repaint();
		
	}
}