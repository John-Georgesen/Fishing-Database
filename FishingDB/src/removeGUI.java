import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class removeGUI extends BasicGUI
{
	public void createGUI()
	{
		//call instance of abstract method from the parent abstract class
		super.createFrame();
		
		//create fonts
		Font labelFont = new Font("Tahoma", Font.BOLD, 20);
		Font titleFont = new Font("Tahoma", Font.BOLD, 35);
		Font areaFont = new Font("Arial", Font.PLAIN, 20);
		Font resultsFont = new Font("Arial", Font.PLAIN, 15);
		
		Border thickBorder = new LineBorder(Color.black, 2);
		
		Map underlineTitle = titleFont.getAttributes();
		underlineTitle.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		//create elements for the panel
		JLabel titleLabel = new JLabel("Remove");
		titleLabel.setFont(titleFont.deriveFont(underlineTitle));
		titleLabel.setSize(500,100);
		titleLabel.setLocation(160,10);
		titleLabel.setForeground(Color.white);
		
		JTextField monthArea = new JTextField(15);
		monthArea.setFont(areaFont);
		monthArea.setSize(200,20);
		monthArea.setLocation(140,140);
		
		JTextField dayArea = new JTextField(15);
		dayArea.setFont(areaFont);
		dayArea.setSize(200,20);
		dayArea.setLocation(140,210);

		JLabel userText = new JLabel("Month:");
		userText.setFont(labelFont);
		userText.setSize(500,100);
		userText.setLocation(50,100);
		userText.setForeground(Color.white);
		
		JLabel passText = new JLabel("Day:");
		passText.setFont(labelFont);
		passText.setSize(500,100);
		passText.setLocation(70,170);
		passText.setForeground(Color.white);
		
		JButton getButton = new JButton("Remove");
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
				String month,day;
				
				//get text from fields
				month = monthArea.getText().toLowerCase();
				day = dayArea.getText().toLowerCase();
				
				try
				{
					Connect conn = new Connect();
					conn.removeSql(month, day);

				} 
				catch (SQLException e)
				{
					System.out.println("Error in connecting through removeGUI");
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
		
		//add elements to panel 
		mainPanel.add(backButton);
		mainPanel.add(monthArea);
		mainPanel.add(dayArea);
		mainPanel.add(passText);
		mainPanel.add(getButton);
		mainPanel.add(userText);
		mainPanel.add(titleLabel);
	}
}
