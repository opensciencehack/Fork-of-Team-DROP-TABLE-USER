import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

public class start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		jsonParser js = new jsonParser();
		
		ArrayList<JsonNode> as = js.parseJson();
		ArrayList<ArrayList<Object>> matrix = new ArrayList<ArrayList<Object>>();
		boolean found = false;
		for(JsonNode a : as)
		{
			found = false;
			String id = a.get("user").toString();
			id = id.substring(id.indexOf(':')+1, id.indexOf(','));
			for(int i = 0; i < matrix.size(); i++)
			{
				if(matrix.get(i).get(0).equals(id))
				{
					int count = (int) matrix.get(i).get(1);
					matrix.get(i).set(1, count+1);
					found = true;
					continue;
				}
			}
			if(!found)
			{
				ArrayList<Object> temsp = new ArrayList<Object>();
				temsp.add(id);
				temsp.add(1);
				matrix.add(temsp);
			}
			
		}
		int minMessages = 0;
		int bigMessage = 0;
		double e = 0;
		int[] below = new int[50];
		ArrayList<Integer> in = new ArrayList<Integer>();
		for(ArrayList<Object> g : matrix)
		{
			int o = (int) g.get(1);
			e += o;
			if(o > bigMessage)
			{
				bigMessage = o;
				in.add(bigMessage);
			}
			if(o < 50)
			{
				below[o]++;
			}
		}
		
		e = e/matrix.size();
		
		System.out.println("Unique users " + matrix.size() + " Average message " + e + " Most messages "+ bigMessage );
		
		System.out.print("The five highest amount of messages(");
		int i = 1;
		
		while(i < 6)
		{
			if(i > in.size()) {break;}
			System.out.print(in.get(in.size()-i) + ", ");
			i++;
		}
		System.out.println(")");
		System.out.println("Number that has below ten.");
		for(int z = 1; z < 50; z++)
		{
			if(below[z]>0)
			{
				System.out.println("Number ("+z+") "+below[z]);
			}
		}
	}

}
