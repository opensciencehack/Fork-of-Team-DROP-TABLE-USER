import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

	private final String DATA_FOLDER = "TweetData/";
    
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