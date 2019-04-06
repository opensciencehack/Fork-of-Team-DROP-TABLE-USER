package Questions;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;

public class UserHandler {
	
	private int uniqueUsers;
	private int activeUsers;
	
	private ArrayList<User> userList;
	public UserHandler(ArrayList<JsonNode> jsNode)
	{
		this.userList = new ArrayList<User>();
		calculateUniqueUsers(jsNode);
	}
	
	public ArrayList<User> getActiveUserList()
	{
		return new ArrayList<User>(userList);
	}
	public int getUserTweets(String id)
	{
		for(User user : userList)
		{
			if(user.getId().equals(id))
			{
				return user.getTweetCount();
			}
		}
		
		return -1;
	}
	public int[] messageInformation(int maxMessageCount)
	{
		int[] messageCount = new int[maxMessageCount];
		for(User user : userList)
		{
			if(user.getTweetCount() >= maxMessageCount) {continue;}
			messageCount[user.getTweetCount()]++;
		}
		return messageCount;
	}
	
	public void calculateActiveUsers(int msgAmount)
	{
		ArrayList<User> tempList = new ArrayList<User>(userList);
		for(User user : tempList)
		{
			if((user.getTweetCount()+user.getRetweet()) < msgAmount)
			{
				userList.remove(user);
			}
		}

		setActiveUsers(userList.size());
	}
	public void setActiveUsers(int amount)
	{
		activeUsers = amount;
	}
	public int getActiveUsers()
	{
		return activeUsers;
	}

	public void calculateUniqueUsers(ArrayList<JsonNode> jsNode)
	{
		ArrayList<User> userList = new ArrayList<User>();
		boolean found = false;
		String id;
		for(JsonNode currentRow : jsNode)
		{
			found = false;
			id = currentRow.get("user").toString();
			id = id.substring(id.indexOf(':')+1, id.indexOf(','));
			
			for(User user : userList)
			{
				if(user.getId().equals(id))
				{
					if(currentRow.get("retweeted_status") != null)
					{
						user.addReTweet();
					}
					else
					{
						user.addTweetCount();
					}
					found = true;
					break;
				}
			}
			if(!found)
			{
				if(currentRow.get("retweeted_status") != null)
				{
					userList.add(new User(id, true));
				}
				else
				{
					userList.add(new User(id, false));
				}

			}
		}
		setUniqueUsers(userList.size());
		setUserList(userList);
	}
	
	private void setUserList(ArrayList<User> u)
	{
		this.userList = u;
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
