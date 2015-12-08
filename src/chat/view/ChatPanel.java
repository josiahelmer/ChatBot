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
	private JTextArea chatArea;
	private JLabel promptLabel;
	private SpringLayout baseLayout;
	private JTextField typingField;
	private JPanel BasePanel;
	
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new  JButton("Enter");
		BasePanel = new JPanel();
		promptLabel = new JLabel("Josiah's chatbot");
		typingField = new JTextField("You can type words in here");

		chatArea = new JTextArea(10,30);
		
		setupPanel();
		setupLayout();
		setupListeners();

	}
	
	private void setupPanel()
	/**
	 * delcaring the data member inside the class
	 */
	{
		this.setPanel(BasePanel);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(typingField);
		this.setBackground(Color.GREEN);
		this.add(promptLabel);
		this.add(chatArea);
		chatArea.setEnabled(false);
		typingField.setToolTipText("");
		

	}
	
	private void setPanel(JPanel basePanel2)
	{
		// TODO Auto-generated method stub
		
	}

	private void setupLayout()
	/**
	 * auto generated code frm the design tab. Set the placment of the objects
	 */
	{
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, 183, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 126, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		
		firstButton.addActionListener(new ActionListener()
		/**
		 * sets parameters for the data members-
		 */
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
