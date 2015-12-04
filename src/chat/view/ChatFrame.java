package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatController;
import chat.view.ChatPanel;


public class ChatFrame extends JFrame
/**
 * delcarations for chatframe
 */
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatController baseController)
	/**
	 * naming the data members
	 */
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	/** 
	 * declaring the  data members that are inside the class
	 */
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setSize(400,400);
		this.setVisible(true);
		this.setTitle("Joisah's ChatBot");
	}
	
	public ChatController getBaseController()
	{
		return baseController;
	}
}
