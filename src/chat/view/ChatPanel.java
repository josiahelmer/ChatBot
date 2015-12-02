package chat.view;

import chat.controller.ChatController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

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
	private JTextField typingField;
	
	
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new  JButton("Do not click the button");
		promptLabel = new JLabel("Josiah's chatbot");
		firstTextField = new JTextField("You can type words in here");
		chatArea = new JTextArea(10,30);
		
		setupPanel();
		setupLayout();
		setupListeners();

	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.setBackground(Color.GREEN);
		this.add(promptLabel);
		this.add(chatArea);
		chatArea.setEnabled(false);
		typingField.setToolTipText("");
		

	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 67, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 126, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 74, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 113, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//Grab user text X
				//send the text to the controller X
				//displays users text X
				//Give text to chatbot to process X
				//get chatbots anwer X
				//dsplay answer X
				//clear user field X
				String userText = typingField.getText();
				String response = baseController.fromUserToChatbot(userText);
				chatArea.append("\nUser" + userText);
				chatArea.append("\nChatbot:" + response);
				typingField.setText("");
				
			}
		});
	}

	public JTextField getTextField()
	{
		return null;
	}
	
}
