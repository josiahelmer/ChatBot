package chat.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
	public String topResults()
	{
		String tweetResults = "";
		
		int topWordLocation = 0;
		int topCount = 0;
		
		for (int index = 0; index < wordsList.size(); index++)
		{
			int wordUseCount = 1;
			
			for(int spot = index + 1; spot < wordsList.size(); spot++)
			{
				if(wordsList.get(index).equals(wordsList.get(spot)))
				{
					wordUseCount++;
				}
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		tweetResults = "The top word in the tweets was" + wordsList.get(topWordLocation) + "and it was used" +
				topCount + "times!";
		return tweetResults;
	}
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		statusList.clear();
		wordsList.clear();
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for (Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split("");
			for (String word : tweetText)
			{
				wordsList.add(removePunctuation(word).toLowerCase());
			}
					
		}
		removeCommonEnglishWords(wordsList);
		removeEmptyText();
	}
	private void removeEmptyText()
	{
		for (int spot = 0; spot < wordsList.size(); spot++)
		{
			if (wordsList.get(spot).equals(""))
			{
				wordsList.remove(spot);
				spot--;
			}
		}
	}

	private void removeCommonEnglishWords(ArrayList<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		
		for (int count = 0; count < wordList.size(); count++)
		{
			for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if (wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
		
	}
	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		try
		{
			Scanner wordFile = new Scanner(new File("commonWords.txt"));
			while (wordFile.hasNext())
				{
					wordCount++;
					wordFile.next();
				}
				wordFile.reset();
				boringWords = new String[wordCount];
				int boringWordCount = 0;
				while (wordFile.hasNext())
				{
					boringWords[boringWordCount] = wordFile.next();
					boringWordCount++;
				}
				wordFile.close();
			}
			catch (FileNotFoundException error)
			{
				baseController.handleErrors(error.getMessage());
				return new String[0];
			}
			return boringWords;
		
	}


	private String removePunctuation(String currentString)
	{
		String punctuation =".,'?:;\"(){}[]<>-";
		
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	public String sampleInvestigation()
	{
		String results = "";
		Query query = new Query("marathon");
		query.setCount(100);
		query.setGeoCode(new GeoLocation(40.587521, -111.869178), 5, Query.MILES);
		query.setSince("2016-1-1");
		try
		{
			QueryResult result = chatbotTwitter.search(query);
			results += ("Count : " + result.getTweets().size());
			for (Status tweet : result.getTweets())
			{
				results += ("@" + tweet.getUser().getName() + ":" + tweet.getText() + "\n");
			}
		}
		catch (TwitterException error)
		{
			error.printStackTrace();
		}
		
		return results;
	}
}
