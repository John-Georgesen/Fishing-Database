

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class loginGUI extends BasicGUI
{	
	public void createGUI()
	{
		super.createFrame();
		
		
		//create fonts
		Font labelFont = new Font("Tahoma", Font.BOLD, 20);
		Font titleFont = new Font("Tahoma", Font.BOLD, 35);
		Font areaFont = new Font("Arial", Font.PLAIN, 20);
		
		Border thickBorder = new LineBorder(Color.black, 2);
		
		Map underlineTitle = titleFont.getAttributes();
		underlineTitle.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		//create elements for panel
		
		JLabel titleLabel = new JLabel("Login");
		titleLabel.setFont(titleFont.deriveFont(underlineTitle));
		titleLabel.setSize(500,100);
		titleLabel.setLocation(185,10);
		titleLabel.setForeground(Color.white);
		
		JTextField userArea = new JTextField(15);
		userArea.setFont(areaFont);
		userArea.setSize(200,20);
		userArea.setLocation(140,140);
		
		JTextField passArea = new JTextField(15);
		passArea.setFont(areaFont);
		passArea.setSize(200,20);
		passArea.setLocation(140,210);
		
		JTextField dbArea = new JTextField(15);
		dbArea.setFont(areaFont);
		dbArea.setSize(200,20);
		dbArea.setLocation(140,280);
		
		JTextField portArea = new JTextField(15);
		portArea.setFont(areaFont);
		portArea.setSize(200,20);
		portArea.setLocation(140,350);
		
		JTextField serverArea = new JTextField(15);
		serverArea.setFont(areaFont);
		serverArea.setSize(200,20);
		serverArea.setLocation(140,420);
		
		JLabel userText = new JLabel("Username:");
		userText.setFont(labelFont);
		userText.setSize(500,100);
		userText.setLocation(10,100);
		userText.setForeground(Color.white);
		
		JLabel passText = new JLabel("Password:");
		passText.setFont(labelFont);
		passText.setSize(500,100);
		passText.setLocation(10,170);
		passText.setForeground(Color.white);
		
		JLabel dbText = new JLabel("Database:");
		dbText.setFont(labelFont);
		dbText.setSize(500,100);
		dbText.setLocation(10,240);
		dbText.setForeground(Color.white);
		
		//port is usually 3306
		JLabel portText = new JLabel("Port:");
		portText.setFont(labelFont);
		portText.setSize(500,100);
		portText.setLocation(10,310);
		portText.setForeground(Color.white);
		
		JLabel serverText = new JLabel("Server:");
		serverText.setFont(labelFont);
		serverText.setSize(500,100);
		serverText.setLocation(10,380);
		serverText.setForeground(Color.white);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBackground(new Color(59, 89, 182));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFocusPainted(false);
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		loginButton.setSize(125,50);
		loginButton.setLocation(185,500);
		loginButton.setBorder(thickBorder);
		
		//execute when button is pressed
		loginButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				Connect.username = userArea.getText();
				Connect.password = passArea.getText();
				Connect.server = serverArea.getText();
				Connect.port = portArea.getText();
				Connect.database = dbArea.getText();
				
				//dispose of current frame
				mainFrame.dispose();
				
				try
				{
					//connect to database
					Connect conn = new Connect();
				} 
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				StartScreen startScreen = new StartScreen();
				startScreen.createGUI();
				startScreen.mainFrame.repaint();
				
			} 
		});
		
		//add elements to frame
		mainPanel.add(dbArea);
		mainPanel.add(portArea);
		mainPanel.add(serverArea);
		mainPanel.add(passArea);
		mainPanel.add(userArea);
		mainPanel.add(passText);
		mainPanel.add(serverText);
		mainPanel.add(portText);
		mainPanel.add(dbText);
		mainPanel.add(loginButton);
		mainPanel.add(userText);
		mainPanel.add(titleLabel);
	}
}
