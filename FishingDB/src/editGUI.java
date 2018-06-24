

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

public class editGUI extends BasicGUI
{
	public void createGUI()
	{
		//call instance of abstract method from the parent abstract class
		super.createFrame();
		
		//create fonts
		Font labelFont = new Font("Tahoma", Font.BOLD, 20);
		Font valueLabelFont = new Font("Tahoma", Font.BOLD, 18);
		Font titleFont = new Font("Tahoma", Font.BOLD, 35);
		Font areaFont = new Font("Arial", Font.PLAIN, 20);
		Font resultsFont = new Font("Arial", Font.PLAIN, 15);
		
		Border thickBorder = new LineBorder(Color.black, 2);
		
		Map underlineTitle = titleFont.getAttributes();
		underlineTitle.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		//create elements for panel
		
		JLabel titleLabel = new JLabel("Edit");
		titleLabel.setFont(titleFont.deriveFont(underlineTitle));
		titleLabel.setSize(500,100);
		titleLabel.setLocation(180,10);
		titleLabel.setForeground(Color.white);
		
		JTextField monthArea = new JTextField(15);
		monthArea.setFont(areaFont);
		monthArea.setSize(200,20);
		monthArea.setLocation(140,140);
		
		JTextField dayArea = new JTextField(15);
		dayArea.setFont(areaFont);
		dayArea.setSize(200,20);
		dayArea.setLocation(140,210);
		
		JTextField whatArea = new JTextField(15);
		whatArea.setFont(areaFont);
		whatArea.setSize(200,20);
		whatArea.setLocation(140,280);
		
		JTextField valueArea = new JTextField(15);
		valueArea.setFont(areaFont);
		valueArea.setSize(200,20);
		valueArea.setLocation(140,350);

		JLabel monthText = new JLabel("Month:");
		monthText.setFont(labelFont);
		monthText.setSize(500,100);
		monthText.setLocation(50,100);
		monthText.setForeground(Color.white);
		
		JLabel dayText = new JLabel("Day:");
		dayText.setFont(labelFont);
		dayText.setSize(500,100);
		dayText.setLocation(70,170);
		dayText.setForeground(Color.white);
		
		JLabel whatText = new JLabel("What:");
		whatText.setFont(labelFont);
		whatText.setSize(500,100);
		whatText.setLocation(60,240);
		whatText.setForeground(Color.white);
		
		JLabel valueText = new JLabel("New Value:");
		valueText.setFont(valueLabelFont);
		valueText.setSize(500,100);
		valueText.setLocation(15,310);
		valueText.setForeground(Color.white);
		
		
		JButton editButton = new JButton("Edit");
		editButton.setBackground(new Color(59, 89, 182));
		editButton.setForeground(Color.WHITE);
		editButton.setFocusPainted(false);
		editButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		editButton.setSize(125,50);
		editButton.setLocation(185,500);
		editButton.setBorder(thickBorder);
		
		//execute when button is pressed
		editButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				String month,day, what, value;
				
				//get text from fields
				month = monthArea.getText().toLowerCase();
				day = dayArea.getText().toLowerCase();
				what = whatArea.getText().toLowerCase();
				value = valueArea.getText().toLowerCase();
				
				try
				{
					Connect conn = new Connect();
					conn.editSql(day, month, what, value);

				} 
				catch (SQLException e)
				{
					System.out.println("Error in connecting through editGUI");
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
		mainPanel.add(whatArea);
		mainPanel.add(dayText);
		mainPanel.add(whatText);
		mainPanel.add(editButton);
		mainPanel.add(monthText);
		mainPanel.add(titleLabel);
		mainPanel.add(valueText);
		mainPanel.add(valueArea);
	}
}
