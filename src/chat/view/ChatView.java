package chat.view;

import javax.swing.JOptionPane;

/**
 * 
 * @author jelm9149
 * @version 1.0 10/21/15
 */
public class ChatView
{
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
}