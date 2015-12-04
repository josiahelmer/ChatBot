package chat.controller;


import chat.model.ChatBot;
import chat.view.ChatView;
import chat.view.ChatFrame;

public class ChatController
{
	/**
	 * Delcarations
	 */
	private ChatBot Simplebot;
	private ChatView Display;
	private ChatFrame baseFrame;
	
	
	public ChatController()
	//Assigning names
	{
		Display = new ChatView();
		String user = Display.collectUserText("What is your name?");
		Simplebot = new ChatBot(user);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	/**
	 * Opening chat message. Grabs the username for Chatbot.java;
	 */
	{
		Display.displayText("Hello" + ChatBot.getUserName());
	}
	
	private void chat()
	/**
	 * message that apears depending on the length checker
	 */
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
		/**
		 * Proccess the user's text and provides a response
		 */
		String botResponse = "Thats a nice topic!";
		
		botResponse = ChatBot.processConversation(conversation);
		
		return botResponse;
	}
	
	private void shutDown()
	/**
	 * Message the apears on shutdown
	 */
	{
		Display.displayText("Goodbye, " + ChatBot.getUserName() + "it has been my pleasure to talk with you");
		System.exit(0);
	}
	/**
	 * Getters and Setters
	 * @return
	 */
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
