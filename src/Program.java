import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;

public class Program {

    public static void main(String[] args) throws IOException {
        
    	// JsonParser jp = new JsonParser();
//        ArrayList<JsonNode> tweets = jp.parseJson();
//    	smt(tweets);
    	
    	ArrayList<Integer> al =  new ArrayList<Integer>();
    	al.add(4200);
    	al.add(757);
    	al.add(422);
        al.add(11);
        
        ChartMaker cm = new ChartMaker();
    	    	
        cm.showCategoryChart("Some chart", "Nr of users", "Nr of tweets", cm.makeRange(1, 4), al);
    }
    
    /*
    static void smt(List<JsonNode> tweets) throws IOException {
        
        Set<User> set = new HashSet<>();
        
        // System.out.println(tweets.get(1).get("id").toString());
        // System.out.println(tweets.get(2).get("id").toString());

        for(JsonNode node : tweets) {
            String userId = node.get("id").toString();
            User tempUser = new User(userId);

            // set.add(tempUser);

            if(!set.contains(tempUser)) {
                set.add(tempUser);
            }
        }
        
        System.out.println(set.size());
    }*/
}