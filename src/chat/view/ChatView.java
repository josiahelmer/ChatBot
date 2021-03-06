package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * 
 * @author jelm9149
 * @version 1.0 10/21/15
 * @version 1.2 Added icon to input window
 */
public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "This message brought to you by the chatbot!";
		chatIcon = new ImageIcon(getClass().getResource("images/VaultBoyIcon.jpg"));
	}
	/**
	 * 
	 * @param displayResponse 
	 * @return
	 */
	public String getUserResponse(String displayText)
	{
		String userInput = "";
		
		userInput = JOptionPane.showInputDialog(null, displayText, windowMessage, 
												JOptionPane.INFORMATION_MESSAGE, chatIcon, null, 
												"Type here please!").toString();
		
		return userInput;
	}
	
	/**
	 * The text displayed on the screen
	 * @param displayText
	 */
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);
	}

	public String collectUserText(String string) {
		return null;
	}
}