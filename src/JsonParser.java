import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

	private final String DATA_FOLDER = "TweetData/";
	
	 public static void main(String[] args) throws IOException {
	 	JsonParser jp = new JsonParser();
	 	ArrayList<JsonNode> uniqueTweets = jp.parseJson("unique_tweets");

	 	jp.writeTweetsWithoutStopWords(uniqueTweets);
	}
    
    public ArrayList<JsonNode> parseJson(String file) throws IOException {
        File dataFile = new File(DATA_FOLDER + file + ".json");
        
        ObjectMapper oMapper = new ObjectMapper();
        JsonNode[] j = oMapper.readValue(dataFile, JsonNode[].class);
        
        return new ArrayList<JsonNode>(Arrays.asList(j));
	}
	
	/**
	 * Writes a text file filtering out stop words from the tweets (used for node graph)
	 * @param tweets
	 * @throws IOException
	 */
	private void writeTweetsWithoutStopWords(ArrayList<JsonNode> tweets) throws IOException {
		PrintWriter pw = new PrintWriter(DATA_FOLDER + "/tweetsWithoutStopwords.txt");
		
		ArrayList<String> stopwords = parseTextFile(new File("stopwords-sv.txt"));
		for(JsonNode j : tweets) {
			String tweet = j.get("text").toString();
			tweet = tweet.replace("@", "");
			tweet = tweet.replace("#", "");
			tweet = tweet.replace("\"", "");
			tweet = tweet.toLowerCase();

			for(String stopword : stopwords) {
				if(tweet.indexOf(stopword) == 0)
					tweet = tweet.replaceAll(stopword + " ", " ");
				tweet = tweet.replaceAll(" " + stopword + " ", " ");
			}
			pw.println(tweet);
		}
		pw.close();
	}

	private ArrayList<JsonNode> parseUniqueTweets() throws IOException {
		ArrayList<JsonNode> allTweets = parseJson("diabetes_tweets-array");
		ArrayList<JsonNode> allUniqueTweets = new ArrayList<>();
		
		for(JsonNode j : allTweets) {
            if(j.get("retweeted_status") == null) {
                allUniqueTweets.add(j);
			}
		}
		return allUniqueTweets;
	}
    
    /**
     * 
     * @param tweets
     * @param fileName should only contain the name of the file, not the ending
     */
    public void writeJson(ArrayList<JsonNode> tweets, String fileName) {
		ObjectMapper oMapper = new ObjectMapper();
		File outputFile = new File(DATA_FOLDER + fileName + ".json");
		try {
			oMapper.writeValue(outputFile, tweets);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> parseTextFile(File file) throws IOException {
		Scanner sc = new Scanner(file);
		
		ArrayList<String> list = new ArrayList<>();
		
		while(sc.hasNextLine()) {
			list.add(sc.nextLine());
		}
		sc.close();

		return list;
	}
}