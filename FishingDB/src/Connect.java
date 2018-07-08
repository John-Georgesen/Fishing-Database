
import java.sql.*;
import java.util.Scanner;  

public class Connect
{
	private Connection connection;
	
	//login variables
	public static String username, password, server, port, database;

	//connect constructor
	public Connect() throws SQLException
	{	
		String connectionString;
		
		//create the String to connect to database
		connectionString = "jdbc:mysql://" + server +":" + port + "/" + database + "?autoReconnect=true&useSSL=false";

		//create connection
		connection = DriverManager
				.getConnection(connectionString,username, password);
		
		System.out.println("Connected to: " + database + " successfully!");
		
		if (connection == null) 
		{
			System.out.println("Connection to: " + database + " failed.");
		} 
	}
	public void editSql(String dayTemp, String monthTemp, String whatTemp, String valueTemp) throws SQLException
	{
		Scanner scan = new Scanner(System.in);
		
		String month, day, what, value;
		
		day = dayTemp;
		month = monthTemp;
		what = whatTemp;
		value = valueTemp;
		
		//check if month value is valid
		if(!(checkMonth(month)))
		{
			System.out.println("Enter a valid month!");
			return;
		}
		
		//check if the day exists
		if(!(checkDay(day,month)))
		{
			System.out.println("Day is not found");
			return;
		}
		
		//create SQL command
		String query = "UPDATE " + month + " SET " + what + " = '" + value + "' WHERE day = " + day;
		
		// create the java statement for SQL
		Statement st = connection.createStatement();
			      
		// execute the query
		st.execute(query);
					
		System.out.println("Successfully entered String data!");
	}
	public void getSql(String monthTemp, String dayTemp, String whatTemp) throws SQLException
	{
		Scanner scan = new Scanner(System.in);
		
		String month, day, what, results = null;
		
		month = monthTemp;
		day = dayTemp;
		what = whatTemp;
		
		//check if month value is valid
		if(!(checkMonth(month)))
		{
			System.out.println("Enter a valid month!");
			return;
		}
		
		//check if day value exists
		if(!(checkDay(day,month)))
		{
			System.out.println("Day is not found");
			return;
		}
		
		else
		{
			//create SQL command
			String query = "SELECT * FROM " + month + " WHERE day = " + day + ";";
		
			// create the java statement
			Statement st = connection.createStatement();
	      
			// execute the query, and get the results
			ResultSet rs = st.executeQuery(query);
	    
			if(what.equals("all"))
			{
				//get all the columns in the table
				while (rs.next())
				{
					System.out.println();
					System.out.println("Day: " + rs.getString(1));
					System.out.println("Location: " + rs.getString(2));
					System.out.println("Baits: " + rs.getString(3));
					System.out.println("Conditions: " + rs.getString(4));
					System.out.println("Amount: " + rs.getString(5));
					System.out.println("Time: " + rs.getString(6));
					System.out.println("Temp: " + rs.getString(7) + " degrees");
					System.out.println("Water Temp: " + rs.getString(8) + " degrees");
					System.out.println("Weight: " + rs.getString(9));
					
					results = ("Location: " + rs.getString(2)
					+ "\nBaits: " + rs.getString(3)
					+ "\nConditions: " + rs.getString(4)
					+ "\nAmount: " + rs.getString(5)
					+ "\nTime: " + rs.getString(6)
					+ "\nTemp: " + rs.getString(7) + " degrees"
					+ "\nWater Temp: " + rs.getString(8) + " degrees"
					+ "\nWeight: " + rs.getString(9));
					
				}
			}
		
			else
			{
				while(rs.next())
				{
					//get a single column in the table
					System.out.println(rs.getString(what));
					results = (rs.getString(what));
				}
			
			}
			getGUI.results = results;
			
		}
	}
	public void addSql(String monthTemp,String locationTemp,String dayTemp,
			String baitsTemp,String conditionsTemp,String timeTemp,
			String amountTemp,String tempTemp,String watertempTemp,
			String weightTemp) throws SQLException
	{
		Scanner scan = new Scanner(System.in);
		
		String month, location, day, baits, conditions, time, amount, temp, watertemp, weight;
		
		month = monthTemp;
		location = locationTemp;
		day = dayTemp;
		baits = baitsTemp;
		conditions = conditionsTemp;
		time = timeTemp;
		amount = amountTemp;
		temp = tempTemp;
		watertemp = watertempTemp;
		weight = weightTemp;
		
		if(!(checkMonth(month)))
		{
			System.out.println("Enter a valid month!");
			return;
		}
		
		if(day.equals("next"))
		{
			//get the most recent day in specified month
			int dayInt = Integer.parseInt(getMaxDay(month));
			dayInt++;
		
			day = String.valueOf(dayInt);
		}
		else
		{	
			//check if day is available
			if(checkDay(day, month))
			{
				System.out.println("Day is already taken");
				return;
			}
		}
		
		String query = "INSERT INTO "+ month + "(day, location,baits,conditions,amount,time,temp,watertemp,weight)"
				+ "VALUES("+day+",'"+location+"','"+baits+"','"+conditions+"',"+amount+",'"+time+"','"+temp+"','"+watertemp+"','"+weight+"'"+");";
	
		// create the java statement
		Statement st = connection.createStatement();
					      
		// execute the query, and get a java resultset
		st.execute(query);
		
		System.out.println("Successfully added data!");
	}
	public void removeSql(String monthTemp,String dayTemp) throws SQLException
	{
		Scanner scan = new Scanner(System.in);
		
		String month, day;
		
		month = monthTemp;
		day = dayTemp;
		
		//check if month value is valid
		if(!(checkMonth(month)))
		{
			System.out.println("Enter a valid month!");
			return;
		}
		
		//check if the day exists
		if(!(checkDay(day,month)))
		{
			System.out.println("Day is not found");
			return;
		}
		
		//create SQL command
		String query = "DELETE FROM " + month + " WHERE day = " + day + ";";
		
		// create the java statement for SQL
		Statement st = connection.createStatement();
			      
		// execute the query
		st.execute(query);
					
		System.out.println("Successfully deleted row!");
	}
	public String getMaxDay(String month) throws SQLException
	{
		String query = "SELECT MAX(day) FROM " + month + ";";

		String maxDay = null;
		
	    // create the java statement
	    Statement st = connection.createStatement();
	      
	    // execute the query and get the results
	    ResultSet rs = st.executeQuery(query);

		
	    while (rs.next())
	    {
	    	//get the largest day value
	    	maxDay = rs.getString(1);
	    }
	    
	    st.close();
	    
	    return maxDay;
	}
	public boolean checkMonth(String month)
	{
		month = month.toLowerCase();
		
		boolean exists = false;
		
		//check if month is valid
		if(month.equals("january") 
				|| month.equals("febuary")
				|| month.equals("march")
				|| month.equals("april")
				|| month.equals("may")
				|| month.equals("june")
				|| month.equals("july")
				|| month.equals("august")
				|| month.equals("september")
				|| month.equals("october")
				|| month.equals("november")
				|| month.equals("december"))
		{
			exists = true;
		}
		return exists;
	}
	public boolean checkDay(String day, String month) throws SQLException
	{
		boolean dayTaken = false; 
		
		int dayInt = Integer.parseInt(day);
		
		month = month.toLowerCase();
		
		//check if day is part of month
		if((month.equals("january") && dayInt > 31) || (month.equals("january") && dayInt < 1))
		{
			return dayTaken;
		}
		else if((month.equals("febuary") && dayInt > 28)  || (month.equals("febuary") && dayInt < 1))
		{
			return dayTaken;
		}
		else if((month.equals("march") && dayInt > 31) || (month.equals("march") && dayInt < 1))
		{
			return dayTaken;
		}
		else if((month.equals("april") && dayInt > 30) || (month.equals("april") && dayInt  < 1))
		{
			return dayTaken;
		}
		else if((month.equals("may") && dayInt > 31) || (month.equals("may") && dayInt < 1))
		{
			return dayTaken;
		}
		else if(( month.equals("june") && dayInt > 30) || ( month.equals("june") && dayInt < 1))
		{
			return dayTaken;
		}
		else if((month.equals("july") && dayInt > 31) || (month.equals("july") && dayInt < 1))
		{
			return dayTaken;
		}
		else if((month.equals("august") && dayInt > 31) || (month.equals("august") && dayInt < 1))
		{
			dayTaken = false;
			return dayTaken;
		}
		else if((month.equals("september") && dayInt > 30) || (month.equals("september") && dayInt < 1))
		{
			return dayTaken;
		}
		else if((month.equals("october") && dayInt > 31) || (month.equals("october") && dayInt < 1))
		{
			return dayTaken;
		}
		else if((month.equals("november") && dayInt > 30) || (month.equals("november") && dayInt < 1))
		{
			return dayTaken;
		}
		else if((month.equals("december") && dayInt > 31) || (month.equals("december") && dayInt < 1))
		{
			return dayTaken;
		}
		else
		{
			//create SQL query statement
			String query = "SELECT * FROM "+ month + ";";
			
			Statement st = connection.createStatement();
		      
		    // execute the query and get results
		    ResultSet rs = st.executeQuery(query);

			//go through all the days and check if day was entered
		    while (rs.next())
		    {	    	
		    	if(rs.getString(1).equals(day))
		    	{
		    		dayTaken = true;
		    	}
		    }
		   
		    st.close();

			return dayTaken;
		}

	}
}