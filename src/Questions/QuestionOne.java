package Questions;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

public class QuestionOne {
	
	private int uniqueUsers;
	private int activeUsers;
	
	public int[] messageInformation(ArrayList<ArrayList<Object>> uniqueUsersList, int maxMessageCount)
	{
		int[] messageCount = new int[maxMessageCount];
		for(ArrayList<Object> user : uniqueUsersList)
		{
			int count = (int)user.get(1);
			if(count >= maxMessageCount) {continue;}
			messageCount[count]++;
		}
		return messageCount;
	}
	
	public ArrayList<String> calculateActiveUsers(ArrayList<ArrayList<Object>> uniqueUsers, int msgAmount)
	{
		ArrayList<String> activeUsers = new ArrayList<String>();
		
		for(ArrayList<Object> uniqueUser : uniqueUsers)
		{
			if((int)uniqueUser.get(1) >= msgAmount)
			{
				activeUsers.add(""+uniqueUser.get(0));
			}
		}
		setActiveUsers(activeUsers.size());
		return activeUsers;
	}
	public void setActiveUsers(int amount)
	{
		activeUsers = amount;
	}
	public int getActiveUsers()
	{
		return activeUsers;
	}

	public ArrayList<ArrayList<Object>> calculateUniqueUsers(ArrayList<JsonNode> jsNode)
	{
		ArrayList<ArrayList<Object>> uniqueUserList = new ArrayList<ArrayList<Object>>();
		
		boolean found = false;
		String id;
		for(JsonNode currentRow : jsNode)
		{
			found = false;
			id = currentRow.get("user").toString();
			id = id.substring(id.indexOf(':')+1, id.indexOf(','));
			
			for(ArrayList<Object> storage : uniqueUserList)
			{
				if(storage.get(0).equals(id))
				{
					int count = (int) storage.get(1);
					
					storage.set(1, count+1);
					found = true;
					break;
				}
			}
			if(!found)
			{
				ArrayList<Object> tempArray = new ArrayList<Object>();
				tempArray.add(id);
				tempArray.add(1);
				uniqueUserList.add(tempArray);
			}
		}
		setUniqueUsers(uniqueUserList.size());
		return uniqueUserList;
	}
	public void setUniqueUsers(int amount)
	{
		uniqueUsers= amount;
	}
	public int getUniqueUsers()
	{
		return uniqueUsers;
	}
}
