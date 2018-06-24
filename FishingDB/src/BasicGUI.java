

import java.awt.Color;

import javax.swing.*;

public abstract class BasicGUI
{
	//create public variables that child classes can access
	public JFrame mainFrame= new JFrame();
	public JPanel mainPanel = new JPanel();
	
	public void createFrame()
	{
		//create basic frame for child classes
		mainFrame.setTitle("Fishing Database");
		
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.gray);
		
		mainFrame.add(mainPanel);
		mainFrame.setSize(500, 600);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	public abstract void createGUI();
}
