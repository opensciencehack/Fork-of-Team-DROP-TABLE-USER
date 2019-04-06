import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

	private final String DATA_FOLDER = "TweetData/";
	
	public static void main(String[] args) throws IOException {
		JsonParser jp = new JsonParser();
		ArrayList<JsonNode> allTweets = jp.parseJson();
		ArrayList<JsonNode> allUniqueTweets = new ArrayList<>();
		
		for(JsonNode j : allTweets) {
            if(j.get("retweeted_status") == null) {
                allUniqueTweets.add(j);
			}
        }
		System.out.println("all tweets: " + allTweets.size());
		System.out.println("unique tweets: " + allUniqueTweets.size());
		jp.writeJson(allUniqueTweets, "unique_tweets");
	}
    
    public ArrayList<JsonNode> parseJson() throws IOException {
        File dataFile = new File(DATA_FOLDER + "diabetes_tweets-array.json");
        
        ObjectMapper oMapper = new ObjectMapper();
        JsonNode[] j = oMapper.readValue(dataFile, JsonNode[].class);
        
        return new ArrayList<JsonNode>(Arrays.asList(j));
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
}