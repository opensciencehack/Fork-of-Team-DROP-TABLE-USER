import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

public class start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		jsonParser js = new jsonParser();

		ArrayList<JsonNode> jNode = js.parseJson();
		QuestionOne q1 = new QuestionOne();
		
		q1.calculateActiveUsers(q1.calculateUniqueUsers(jNode), 3);
		
		System.out.println("Unique users: " +q1.getUniqueUsers() +" Active users:" + q1.getActiveUsers());
	}
	

}
