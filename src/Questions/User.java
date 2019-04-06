package Questions;

public class User {
	
	private String id;
	
	private String name;
	
	private String screenName;
	
	private int followerCount;
	
	private int tweetCount;
	
	private int mentions;
	
	private int retweetCount;
	
	public User(String id, boolean reTweet)
	{
		this.id = id;
		followerCount = 0;
		if(reTweet) 
		{
			retweetCount = 1;
			tweetCount = 0;
		}
		else
		{
			tweetCount = 1;
			retweetCount = 0;
		}
		mentions = 0;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void addTweetCount()
	{
		tweetCount++;
	}
	
	public int getTweetCount()
	{
		return tweetCount;
	}
	public void addReTweet()
	{
		retweetCount++;
	}
	public int getMentions()
	{
		return mentions;
	}
	public void addMention()
	{
		mentions++;
	}
	public int getRetweet()
	{
		return retweetCount;
	}
}
