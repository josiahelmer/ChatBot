package chat.controller;


import chat.model.ChatBot;
import chat.view.ChatView;
import chat.view.ChatFrame;

public class ChatController
{
	private ChatBot Chatbot;
	private ChatView ChatView;
	private ChatFrame baseFrame;
	
	
	public ChatController()
	{
		ChatView = new ChatView();
		String user = ChatView.collectUserText("What is your name?");
		Chatbot = new ChatBot(user);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	
	{
		ChatView.displayText("Hello" + Chatbot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String conversation = ChatView.collectUserText("What would you like to talk about today?");
		while(Chatbot.lengthChecker(conversation))
		{
			
			conversation = ChatBot.processConversation(conversation);
			conversation = ChatView.collectUserText(conversation);
		}
	}
	
	private void shutDown()
	{
		
	}

	public ChatBot getChatbot()
	{
		return Chatbot;
	}

	public void setChatbot(ChatBot Chatbot)
	{
		this.Chatbot = Chatbot;
	}

	public ChatView getChatView()
	{
		return ChatView;
	}

	public void setChatView(ChatView ChatView)
	{
		this.ChatView = ChatView;
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
