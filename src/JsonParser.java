import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

	private final String DATA_FOLDER = "TweetData/";
	
    public static void main(String[] args) {
    	try {
    		JsonParser jp = new JsonParser();
    		jp.parseJson();
    		//jp.writeJson(tweets, "truncatedJson");

    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void parseJson() throws IOException {
        File dataFile = new File(DATA_FOLDER + "diabetes_tweets.json");

        ObjectMapper oMapper = new ObjectMapper();

		File parsedTweetFile = new File(DATA_FOLDER + "parsed_tweets.json");

		// Construct a tweet object
		JsonNode node = oMapper.readTree(dataFile);
		Tweet tweet = new Tweet(node);

		// Write out tweet object as json
		JsonNode tweetNode = oMapper.convertValue(tweet, JsonNode.class);

		oMapper.writeValue(parsedTweetFile, tweetNode);
    }

    private void optimizeJSONFile() {

	}

    /**
     * 
     * @param tweets
     * @param fileName should only contain the name of the file, not the ending
     */
    public void writeJson(ArrayList<Tweet> tweets, String fileName) {
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