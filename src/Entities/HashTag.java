package Entities;

public class HashTag {
	private String text;
	private int occurances;
	
	public HashTag(String text)
	{
		this.text = text;
		occurances =1;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void addOccurance()
	{
		occurances++;
	}
}
