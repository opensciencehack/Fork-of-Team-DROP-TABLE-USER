package Questions;

public class User {
	
	private String id;
	
	private String name;
	
	private String screenName;
	
	private int followerCount;
	
	private int tweetCount;
	
	public User(String id)
	{
		this.id = id;
		followerCount = 0;
		tweetCount = 1;
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
}
