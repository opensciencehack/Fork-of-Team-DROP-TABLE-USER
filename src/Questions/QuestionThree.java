package Questions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;

public class QuestionThree {

	public Dictionary<String, Integer> fillIt(Dictionary<String, Integer> dataList, String data, int cutLength)
	{
		if(data.equals("[]")) {return dataList;}
		String[] m = data.substring(1).split("\\{");
		
		for(int i =1; i < m.length; i++)
		{
			data = m[i].substring(cutLength, m[i].indexOf("\",\""));
			if(dataList.get(data) == null)
			{
				dataList.put(data, 1);
			}
			else
			{
				dataList.put(data, dataList.get(data)+1);
			}
		}
	}
	public void extractHashTags(ArrayList<String> activeUsers, ArrayList<JsonNode> jNode) throws IOException
	{
		Dictionary<String, Integer> hashDic = new Hashtable<String, Integer>();
		Dictionary<String, Integer> mentionDic = new Hashtable<String, Integer>();
		String info;
		boolean found;
		int counter = 0;
		for(JsonNode tweet : jNode)
		{
			found = false;
			info = tweet.get("user").toString();
			for(String userId : activeUsers)
			{
				if(info.contains(userId))
				{
					found = true;
					break;
				}
			}
			if(!found) {continue;}
				String hashtags = tweet.get("entities").get("hashtags").toString();
				String userMentions = tweet.get("entities").get("user_mentions").toString();
				
				hashDic = fillIt(hashDic, hashtags, 8);
				mentionDic = fillIt(mentionDic, hashtags, 17);
			
		}
		System.out.println("Total amount of hashtags :" + counter + " UNIQUE " + d.size());
		
		
		int[] frequevent = new int[10];
		int highestOccurence = 0;
		ArrayList<String> t = new ArrayList<String>();
	    for (Enumeration<String> e = d.keys(); e.hasMoreElements();) {
	    	String te = e.nextElement();
	    	int count = d.get(te);
	    	if(count > 0 && count < 10)
	    	{
	    		frequevent[count]++;
	    	}
	    	if(count > highestOccurence)
	    	{
	    		highestOccurence = count;
	    		t.add(te);
	    	}
	    }
		for(int i = 1; i < 10; i++)
		{
			System.out.println(frequevent[i] + " hashtags occured "+i+" times.");
		}
		System.out.println("The highest amount of times a single hashtag occured was " + highestOccurence + " The hashtag was #"+t);
		System.out.println("Honorble mentions..");
		for(String hash : t)
		{
			System.out.print("#"+hash+ " ");
		}
	}
}
