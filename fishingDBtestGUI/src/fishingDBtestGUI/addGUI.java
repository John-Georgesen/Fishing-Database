package fishingDBtestGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class addGUI extends BasicGUI
{
	public void createGUI()
	{
		//call instance of abstract method from the parent abstract class
		super.createFrame();
		
		//create fonts
		Font labelFont = new Font("Tahoma", Font.BOLD, 16);
		Font titleFont = new Font("Tahoma", Font.BOLD, 35);
		Font areaFont = new Font("Arial", Font.PLAIN, 15);
		
		Border thickBorder = new LineBorder(Color.black, 2);
		
		//add underline to title
		Map underlineTitle = titleFont.getAttributes();
		underlineTitle.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		//create all elements to add to JPanel
		
		JLabel titleLabel = new JLabel("Add");
		titleLabel.setFont(titleFont.deriveFont(underlineTitle));
		titleLabel.setSize(500,100);
		titleLabel.setLocation(190,10);
		titleLabel.setForeground(Color.white);
		
		JTextField monthArea = new JTextField(15);
		monthArea.setFont(areaFont);
		monthArea.setSize(200,20);
		monthArea.setLocation(140,90);
		
		JTextField dayArea = new JTextField(15);
		dayArea.setFont(areaFont);
		dayArea.setSize(200,20);
		dayArea.setLocation(140,130);
		
		JTextField locArea = new JTextField(15);
		locArea.setFont(areaFont);
		locArea.setSize(200,20);
		locArea.setLocation(140,170);
		
		JTextField baitArea = new JTextField(15);
		baitArea.setFont(areaFont);
		baitArea.setSize(200,20);
		baitArea.setLocation(140,210);
		
		JTextField conditionArea = new JTextField(15);
		conditionArea.setFont(areaFont);
		conditionArea.setSize(200,20);
		conditionArea.setLocation(140,250);
		
		JTextField amountArea = new JTextField(15);
		amountArea.setFont(areaFont);
		amountArea.setSize(200,20);
		amountArea.setLocation(140,290);
		
		JTextField timeArea = new JTextField(15);
		timeArea.setFont(areaFont);
		timeArea.setSize(200,20);
		timeArea.setLocation(140,330);
		
		JTextField tempArea = new JTextField(15);
		tempArea.setFont(areaFont);
		tempArea.setSize(200,20);
		tempArea.setLocation(140,370);
		
		JTextField waterTempArea = new JTextField(15);
		waterTempArea.setFont(areaFont);
		waterTempArea.setSize(200,20);
		waterTempArea.setLocation(140,410);
		
		JTextField sizeArea = new JTextField(15);
		sizeArea.setFont(areaFont);
		sizeArea.setSize(200,20);
		sizeArea.setLocation(140,450);

		JLabel monthText = new JLabel("Month:");
		monthText.setFont(labelFont);
		monthText.setSize(500,80);
		monthText.setLocation(70,60);
		monthText.setForeground(Color.white);
		
		JLabel dayText = new JLabel("Day:");
		dayText.setFont(labelFont);
		dayText.setSize(500,80);
		dayText.setLocation(90,100);
		dayText.setForeground(Color.white);
		
		JLabel locationText = new JLabel("Location(s):");
		locationText.setFont(labelFont);
		locationText.setSize(500,80);
		locationText.setLocation(30,140);
		locationText.setForeground(Color.white);
		
		JLabel baitText = new JLabel("Bait(s):");
		baitText.setFont(labelFont);
		baitText.setSize(500,80);
		baitText.setLocation(70,180);
		baitText.setForeground(Color.white);
		
		JLabel conditionText = new JLabel("Conditions:");
		conditionText.setFont(labelFont);
		conditionText.setSize(500,80);
		conditionText.setLocation(35,220);
		conditionText.setForeground(Color.white);
		
		JLabel amountText = new JLabel("Amount:");
		amountText.setFont(labelFont);
		amountText.setSize(500,80);
		amountText.setLocation(60,260);
		amountText.setForeground(Color.white);
		
		JLabel timeText = new JLabel("Time:");
		timeText.setFont(labelFont);
		timeText.setSize(500,80);
		timeText.setLocation(85,300);
		timeText.setForeground(Color.white);
		
		JLabel tempText = new JLabel("Temp:");
		tempText.setFont(labelFont);
		tempText.setSize(500,80);
		tempText.setLocation(80,340);
		tempText.setForeground(Color.white);
		
		JLabel waterTempText = new JLabel("Water Temp:");
		waterTempText.setFont(labelFont);
		waterTempText.setSize(500,80);
		waterTempText.setLocation(20,380);
		waterTempText.setForeground(Color.white);
		
		JLabel sizeText = new JLabel("Size:");
		sizeText.setFont(labelFont);
		sizeText.setSize(500,80);
		sizeText.setLocation(90,420);
		sizeText.setForeground(Color.white);
		
		
		JButton getButton = new JButton("Add");
		getButton.setBackground(new Color(59, 89, 182));
		getButton.setForeground(Color.WHITE);
		getButton.setFocusPainted(false);
		getButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		getButton.setSize(125,50);
		getButton.setLocation(185,500);
		getButton.setBorder(thickBorder);
		
		//execute when button is pressed
		getButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				String month, location, day, baits, conditions, time, amount, temp, watertemp, weight;
				
				//get text from the fields
				month = monthArea.getText().toLowerCase();
				location = locArea.getText().toLowerCase();
				day = dayArea.getText().toLowerCase();
				baits = baitArea.getText().toLowerCase();
				conditions = conditionArea.getText().toLowerCase();
				time = timeArea.getText().toLowerCase();
				amount = amountArea.getText().toLowerCase();
				temp = tempArea.getText().toLowerCase();
				watertemp  = waterTempArea.getText().toLowerCase();
				weight = sizeArea.getText().toLowerCase();
				
				try
				{
					Connect conn = new Connect();

					conn.addSql(month,location,day,baits,conditions,time,amount,
							temp,watertemp,weight);
				} 
				catch (SQLException e)
				{
					System.out.println("Error in connecting through addGUI");
				}
			} 
		});
		
		//button to return to main menu
		JButton backButton = new JButton("Back");
		backButton.setBackground(new Color(59, 89, 182));
		backButton.setForeground(Color.WHITE);
		backButton.setFocusPainted(false);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		backButton.setSize(50,30);
		backButton.setLocation(10,10);
		backButton.setBorder(thickBorder);
				
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				StartScreen startScreen = new StartScreen();
				startScreen.createGUI();
				startScreen.mainFrame.repaint();
						
				mainFrame.dispose();
			} 
		});
		
		//add all elements to panel
		mainPanel.add(backButton);
		mainPanel.add(monthArea);
		mainPanel.add(dayArea);
		mainPanel.add(locArea);
		mainPanel.add(baitArea);
		mainPanel.add(conditionArea);
		mainPanel.add(amountArea);
		mainPanel.add(timeArea);
		mainPanel.add(tempArea);
		mainPanel.add(waterTempArea);
		mainPanel.add(sizeArea);
		mainPanel.add(monthText);
		mainPanel.add(dayText);
		mainPanel.add(locationText);
		mainPanel.add(baitText);
		mainPanel.add(conditionText);
		mainPanel.add(amountText);
		mainPanel.add(timeText);
		mainPanel.add(tempText);
		mainPanel.add(waterTempText);
		mainPanel.add(sizeText);
		mainPanel.add(getButton);
		mainPanel.add(titleLabel);
	}
}

