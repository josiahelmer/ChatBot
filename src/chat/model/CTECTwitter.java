package chat.model;

import java.util.ArrayList;

import twitter4j.*;
import chat.controller.ChatController;

public class CTECTwitter
{
	// Declaration
	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;

	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}

	public void sendTweet(String message)
	{
		try
		{
			chatbotTwitter.updateStatus("Josiah Elmer #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
			// if boolaen method set variaable to true here
		}
		catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
}
