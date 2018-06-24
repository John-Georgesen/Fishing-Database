package fishingDBtestGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class StartScreen extends BasicGUI
{
	public void createGUI()
	{
		//call instance of abstract method from the parent abstract class
		super.createFrame();
		
		Border thickBorder = new LineBorder(Color.black, 2);
		
		Font buttonFont = new Font("Tahoma", Font.BOLD, 20);
		Font titleFont = new Font("Tahoma", Font.BOLD, 35);
		
		//making the title font underlined
		Map underlineTitle = titleFont.getAttributes();
		underlineTitle.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		JLabel title = new JLabel("Fishing Database");
		title.setFont(titleFont.deriveFont(underlineTitle));
		title.setSize(500,100);
		title.setLocation(65,10);
		title.setForeground(Color.white);

		//create buttons 
		
		JButton getButton = new JButton("GET");
		getButton.setBackground(new Color(59, 89, 182));
		getButton.setForeground(Color.WHITE);
		getButton.setFocusPainted(false);
		getButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		getButton.setSize(175,175);
		getButton.setLocation(50,150);
		getButton.setBorder(thickBorder);
		
		//execute when button is pressed
		getButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				getGUI get = new getGUI();
				
				//dispose of current frame
				mainFrame.dispose();
				
				//call getGUI method which displays getGUI interface
				get.createGUI();
			} 
		});
		
		
		
		JButton addButton = new JButton("ADD");
		addButton.setBackground(new Color(59, 89, 182));
		addButton.setForeground(Color.WHITE);
		addButton.setFocusPainted(false);
		addButton.setFont(buttonFont);
		addButton.setSize(175,175);
		addButton.setLocation(50,350);
		addButton.setBorder(thickBorder);
		
		//execute when button is pressed
		addButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				addGUI add = new addGUI();
				
				//dispose off current frame
				mainFrame.dispose();
				
				//call addGUI method which displays addGUI interface
				add.createGUI();
			} 
		});
		
		
		JButton removeButton = new JButton("REMOVE");
		removeButton.setBackground(new Color(59, 89, 182));
		removeButton.setForeground(Color.WHITE);
		removeButton.setFocusPainted(false);
		removeButton.setFont(buttonFont);
		removeButton.setSize(175,175);
		removeButton.setLocation(250,150);
		removeButton.setBorder(thickBorder);
		
		//execute when button is pressed
		removeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				removeGUI remove = new removeGUI();
				
				//dispose of current frame
				mainFrame.dispose();
				
				//call getGUI method which displays getGUI interface
				remove.createGUI();
			} 
		});
		
		JButton editButton = new JButton("EDIT");
		editButton.setBackground(new Color(59, 89, 182));
		editButton.setForeground(Color.WHITE);
		editButton.setFocusPainted(false);
		editButton.setFont(buttonFont);
		editButton.setSize(175,175);
		editButton.setLocation(250,350);
		editButton.setBorder(thickBorder);
		
		//execute when button is pressed
		editButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				editGUI edit = new editGUI();
				
				//dispose of current frame
				mainFrame.dispose();
				
				//call getGUI method which displays getGUI interface
				edit.createGUI();
			} 
		});
		
		//add elements to panel
		mainPanel.add(title);
		mainPanel.add(getButton);
		mainPanel.add(addButton);
		mainPanel.add(removeButton);
		mainPanel.add(editButton);
	}
}
