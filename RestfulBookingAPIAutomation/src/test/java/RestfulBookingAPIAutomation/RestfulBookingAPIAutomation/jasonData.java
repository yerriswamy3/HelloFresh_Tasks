package RestfulBookingAPIAutomation.RestfulBookingAPIAutomation;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class jasonData {
	
	public JSONObject getjason() {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject=null;
		 
        try {
 
            Object obj = parser.parse(new FileReader("C:\\Users\\Santhan\\eclipse-workspace2\\RestfulBookingAPIAutomation\\data.json"));
 
             jsonObject = (JSONObject) obj;
 
            System.out.println(jsonObject);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
	}

}
