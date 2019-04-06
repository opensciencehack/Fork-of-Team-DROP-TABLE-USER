import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonNode;

import Questions.QuestionThree;
import Questions.UserHandler;

public class start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		jsonParser js = new jsonParser();

		ArrayList<JsonNode> jNode = js.parseJson();
		UserHandler q1 = new UserHandler(jNode);
		QuestionThree q3 = new QuestionThree();
		
		
		q1.calculateActiveUsers(3);
		System.out.println(q1.getUserTweets("1400777804"));
		//q3.extractHashTags(q1.calculateActiveUsers(q1.calculateUniqueUsers(jNode), 3), jNode);
		
		System.out.println("Unique users: " +q1.getUniqueUsers() +" Active users:" + q1.getActiveUsers());
	}
	

}
