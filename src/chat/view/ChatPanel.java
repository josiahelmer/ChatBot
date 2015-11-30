package chat.view;

import chat.controller.ChatController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton firstButton;
	private JTextField firstTextField;
	private JTextArea chatArea;
	private JLabel promptLabel;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new  JButton("Do not click the button");
		firstTextField = new JTextField("You can type words in here");
		
		setupPanel();
		setupLayout();
		setupListeners();

	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);

	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				firstTextField.setText("don't click it");
			}
		});
	}

	public JTextField getTextField()
	{
		return null;
	}
	
}
