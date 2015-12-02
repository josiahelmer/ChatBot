package chat.controller;


import chat.model.ChatBot;
import chat.view.ChatView;
import chat.view.ChatFrame;

public class ChatController
{
	private ChatBot Simplebot;
	private ChatView Display;
	private ChatFrame baseFrame;
	
	
	public ChatController()
	{
		Display = new ChatView();
		String user = Display.collectUserText("What is your name?");
		Simplebot = new ChatBot(user);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	
	{
		Display.displayText("Hello" + Simplebot.getUserName());
		//chat();
	}
	
	private void chat()
	{
		String conversation = Display.collectUserText("What would you like to talk about today?");
		while(Simplebot.lengthChecker(conversation))
		{
			
			conversation = ChatBot.processConversation(conversation);
			conversation = Display.collectUserText(conversation);
		}
	}
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		botResponse = ChatBot.processConversation(conversation);
		
		return botResponse;
	}
	
	private void shutDown()
	{
		Display.displayText("Goodbye, " + ChatBot.getUserName() + "it has been my pleasure to talk with you");
		System.exit(0);
	}

	public ChatBot getSimplebot()
	{
		return Simplebot;
	}

	public void setSimplebot(ChatBot SimpleBot)
	{
		this.Simplebot = Simplebot;
	}

	public ChatView getDisplay()
	{
		return Display;
	}

	public void setDisplay(ChatView Display)
	{
		this.Display = Display;
	}

	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}

	public void setBaseFrame(ChatFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}


	
}
