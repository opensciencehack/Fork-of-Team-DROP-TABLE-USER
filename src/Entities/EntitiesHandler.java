package Entities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;

import User.User;

public class EntitiesHandler{
	
	private ArrayList<HashTag> hashtags;
	
	private int hashCount;
	public EntitiesHandler()
	{
		hashtags = new ArrayList<HashTag>();
		hashCount = 0;
	}
	public int getHashCount() {return hashCount;}
	public void fillHash(String data, int cutLength)
	{
		if(data.equals("[]")) {return;}
		String[] m = data.substring(1).split("\\{");
		
		boolean found = false;
		for(int i =1; i < m.length; i++)
		{
			hashCount++;
			data = m[i].substring(cutLength, m[i].indexOf("\",\""));
			found = false;
			for(HashTag hash : hashtags)
			{
				if(hash.getText().equals(data))
				{
					hash.addOccurance();
					found = true;
					break;
				}
			}
			if(found) { continue;}
			hashtags.add(new HashTag(data));
		}
	}
	
	public void fillMentions(String data, ArrayList<User> userList)
	{
		if(data.equals("[]")) {return;}
		String[] m = data.substring(1).split("\\{");
		
		boolean found = false;
		for(int i =1; i < m.length; i++)
		{
			data = m[i].substring(m[i].indexOf("\"id\":"));
			data = data.substring(5, data.indexOf(","));
			found = false;
			for(User user : userList)
			{
				if(user.getId().equals(data))
				{
					user.addMention();
					break;
				}
			}
		}
	}
	public void extractEntities(ArrayList<User> activeUsers, ArrayList<JsonNode> jNode) throws IOException
	{
		String info;
		boolean found;
		int counter = 0;
		for(JsonNode tweet : jNode)
		{
			found = false;
			info = tweet.get("user").toString();
			for(User user : activeUsers)
			{
				if(info.contains(user.getId()))
				{
					found = true;
					break;
				}
			}
			if(!found) {continue;}
				String hashtags = tweet.get("entities").get("hashtags").toString();
				String userMentions = tweet.get("entities").get("user_mentions").toString();
				
				fillHash(hashtags, 8);
				fillMentions(userMentions, activeUsers);
			
		}
	}
}
