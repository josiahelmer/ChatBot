package chat.controller;


import chat.model.ChatBot;
import chat.view.ChatView;



public class ChatController
{
	private ChatBot simpleBot;
	private ChatView display;
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.collectUserText("What is your name?");
		simpleBot = new ChatBot(user);
	}
	
	public void start()
	
	{
		display.displayText("Hello" + simpleBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String conversation = display.collectUserText("What would you like to talk about today?");
		while(simpleBot.lengthChecker(conversation))
		{
			if(simpleBot.lengthChecker(conversation))
			{
				display.displayText("Wow, I had no idea you loved " + simpleBot.getContent());
			}
			else if(simpleBot.memeChecker(conversation))
			{
				display.displayText("No meme?");
			}
			
			conversation = display.collectUserText(conversation);
		}
	}
	
	private void shutDown()
	{
		
	}
	
	
}
