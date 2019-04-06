import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

import Questions.QuestionOne;
import Questions.QuestionThree;

public class start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		jsonParser js = new jsonParser();

		ArrayList<JsonNode> jNode = js.parseJson();
		QuestionOne q1 = new QuestionOne();
		QuestionThree q3 = new QuestionThree();
		q1.calculateActiveUsers(q1.calculateUniqueUsers(jNode), 3);
		int[] messages = q1.messageInformation(q1.calculateUniqueUsers(jNode), 10);
		
		for(int i = 0; i < messages.length; i++ )
		{
			System.out.println("Number of users that only sent " + i +" tweets :" +messages[i]);
		}
		//q3.extractHashTags(q1.calculateActiveUsers(q1.calculateUniqueUsers(jNode), 3), jNode);
		
		System.out.println("Unique users: " +q1.getUniqueUsers() +" Active users:" + q1.getActiveUsers());
	}
	

}
