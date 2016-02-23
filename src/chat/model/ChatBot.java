package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Josiah Elmer
=======
 * @version 1.3 10/28/15 Built and called the build MemesList. Repaired the getContentsMethod
>>>>>>> Stashed changes
 */
public class ChatBot

{
	private ArrayList<String> memesList;
	private ArrayList<String> politicaltopicList;
	private String UserName;
	private String content;
	private String Josiah;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public ChatBot(String UserName)
	/**
	 * Naming the data members
	 */
	{
		this.memesList = new ArrayList<String>();
		this.politicaltopicList = new ArrayList<String>();
		this.UserName = Josiah;
		this.content = "Josiah";
		
		buildMemesList();
		buildPoliticalTopicsList();
	}
	
	private void buildMemesList()
	/**
	 * Building the memes list
	 */
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("one does not simply");
		this.memesList.add("pepperidge farm remembers");
		this.memesList.add("am I the only one around here?");
		this.memesList.add("fistpump baby");
		this.memesList.add("I will find you");
		this.memesList.add("unpopular opinion puffin");
		this.memesList.add("philociraptor");
		this.memesList.add("I was born in the ");
		
	}
	

	private void buildPoliticalTopicsList()
	/**
	 * Building political Topics list
	 */
	{
		this.politicaltopicList.add("Gun Control");
		this.politicaltopicList.add("Gay Marriage");
		this.politicaltopicList.add("Affirmative Action");
		this.politicaltopicList.add("Drug policies");
		this.politicaltopicList.add("Term limits");
		this.politicaltopicList.add("Campaign Finance");
		this.politicaltopicList.add("Social Security");
		this.politicaltopicList.add("Net Neutrality");
		this.politicaltopicList.add("Patriot act");
		this.politicaltopicList.add("Abortion");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if(currentInput != null)
		{
			if(currentInput.length() > 0)
			{
				return true;
			}
		}
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */

		
	
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content))
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	
	public boolean keyboardMashChecker(String currentInput)
	{
	 boolean isMash = false;
	 
	 return isMash;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean haspoliticalTopic = false;
		
		for(String politics: politicaltopicList)
		{
			if(currentInput.toLowerCase().contains(politics.toLowerCase()))
			{
				haspoliticalTopic = true;
			}
		}
		return  haspoliticalTopic;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String meme: memesList)
		{
			if(currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMeme = true;
			}
			
		}
			
		return hasMeme;
	}
	

	public String processQuestion(String currentInput)
	{
		String backTalk = " oh, what else would you like talk about ";
		int randomTopic =(int) (Math.random() * 5); //Generates a rendom number betwwen 0 and 4
		
		if(keyboardMashChecker(currentInput))
		{
			return "Stop mashing the keyboard!!";
		}
		
		switch (randomTopic)
		{
		case 0:
			if(contentChecker(currentInput))
			{
				backTalk = "Thats a great topic! What else are you into?";
			}
			else
			{
				backTalk = "you realy should talk";
			}
			break;
		case 1:
			if(memeChecker(currentInput))
			{
				backTalk = "That is a popular meme this year! What is your favorite food?";
			}
			break;
		case 2:
			if(politicalTopicChecker(currentInput))
			{
				backTalk = "comment and a question";
			}
			break;
		case 3:
			if(currentInput.length() > 23)
			{
				backTalk = "comment and a question";
			}
			break;
		case 4:
			//Random topic for chat here
			break;
		default:
			//Never will happen
			
			break;
		}
		
		
		return backTalk;
		
	}
	/**
	 * how you retrieve the username
	 * @return
	 */
	public static String getUserName()
	{
		return getUserName();
	}
	

	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicaltopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	public static String processConversation(String conversation)
	{
		return null;
	}
}
