package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * 
 * @author jelm9149
 * @version 1.0 10/21/15
 * @version 1.1 Added constructor
 */
public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "This message brought to you by the chatbot!";
		chatIcon = new ImageIcon(getClass().getResource("image/VaultBoyIcon.png"));
	}
	/**
	 * 
	 * @param displayResponse 
	 * @return
	 */
	public String getUserResponse(String displayText)
	{
		String userInput = "";
		
		userInput = JOptionPane.showInputDialog(null, displayText);
		
		return userInput;
	}
	
	/**
	 * The text displayed on the screen
	 * @param displayText
	 */
	public void displayText(String displayText)
	{
		JOptionPane.showInputDialog(null, displayText);
	}

	public String collectUserText(String string) {
		return null;
	}
}