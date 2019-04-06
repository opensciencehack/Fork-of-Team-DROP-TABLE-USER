import java.io.IOException;

import java.util.ArrayList;


import com.fasterxml.jackson.databind.JsonNode;

import Entities.EntitiesHandler;
import User.User;
import User.UserHandler;

public class start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		jsonParser js = new jsonParser();

		ArrayList<JsonNode> jNode = js.parseJson();
		UserHandler q1 = new UserHandler(jNode);
		
		EntitiesHandler eh = new EntitiesHandler();
		
		
		q1.calculateActiveUsers(3);
		
		eh.extractEntities(q1.getActiveUserList(), jNode);
		
		//q3.extractHashTags(q1.calculateActiveUsers(q1.calculateUniqueUsers(jNode), 3), jNode);
		
		System.out.println("Unique users: " +q1.getUniqueUsers() +" Active users:" + q1.getActiveUsers());
	}
	

}
