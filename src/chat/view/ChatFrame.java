package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatController;
import chat.view.ChatPanel;


public class ChatFrame extends JFrame
{
	
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setSize(400,400);
		this.setVisible(true);
	}
	
	public ChatController getBaseController()
	{
		return baseController;
	}
}
