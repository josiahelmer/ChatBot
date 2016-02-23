package chat.view;

import chat.controller.ChatController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JScrollPane textPane;
	private JButton firstButton;
	private JTextArea chatArea;
	private JLabel promptLabel;
	private SpringLayout baseLayout;
	private JTextField TextField;
	private JPanel BasePanel;
	
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		firstButton = new  JButton("Enter");
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -10, SpringLayout.SOUTH, this);
		BasePanel = new JPanel();
		promptLabel = new JLabel("Josiah's chatbot");
		TextField = new JTextField("You can type words in here");
		baseLayout.putConstraint(SpringLayout.NORTH, TextField, -1, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, TextField, 63, SpringLayout.EAST, firstButton);
		chatArea = new JTextArea(10,30);
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();

	}
	
	private void setupChatPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		textPane = new JScrollPane(chatArea);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void setupPanel()
	/**
	 * delcaring the data member inside the class
	 */
	{
		this.setPanel(BasePanel);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(TextField);
		this.setBackground(Color.GREEN);
		this.add(promptLabel);
		chatArea.setEnabled(false);
		TextField.setToolTipText("");
		

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
				String userText = TextField.getText();
				String response = baseController.fromUserToChatbot(userText);
				chatArea.append("\nUser" + userText);
				chatArea.append("\nChatbot:" + response);
				TextField.setText("");
				
			}
		});
	}

	public JTextField getTextField()
	{
		return null;
	}
	
}
