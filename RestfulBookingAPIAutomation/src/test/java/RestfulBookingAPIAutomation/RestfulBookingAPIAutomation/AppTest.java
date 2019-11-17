package RestfulBookingAPIAutomation.RestfulBookingAPIAutomation;



import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class AppTest {
	
	@Test(priority=1)
	public void createBooking() {
		
		       jasonData jd = new jasonData();
		       
		
		
				RestAssured.baseURI = "https://automationintesting.online/booking/";

				
				
				RequestSpecification httpRequest = RestAssured.given();
				
				httpRequest.header("Content-Type", "application/json");
				
				JSONObject requestParams = jd.getjason();
				
				

				httpRequest.body(requestParams.toJSONString());
				
				Response response = httpRequest.request(Method.POST);

				
				String responseBody = response.getBody().asString();
				System.out.println("Response Body is =>  " + responseBody);
				
				JsonPath jsonPathEvaluator = response.jsonPath();
				
				 int bookingID = jsonPathEvaluator.get("bookingid");
				 int roomID = jsonPathEvaluator.get("booking.roomid");
				 String firstName = (String)jsonPathEvaluator.get("booking.firstname");
				 String lastname = (String)jsonPathEvaluator.get("booking.lastname");
				 
				 String status = (String)jsonPathEvaluator.get("status");
				 System.out.println(firstName+""+status);
				 
				
				 Assert.assertEquals(2, bookingID);
				 Assert.assertEquals(2, roomID);
				 Assert.assertEquals("string", firstName);
				 Assert.assertEquals("string", lastname);
				 
				
		
	}
	
	@Test(priority=2)
	public void getBooking() {
		
				RestAssured.baseURI = "https://automationintesting.online/booking/1";

				
				RequestSpecification httpRequest = RestAssured.given();

				
				Response response = httpRequest.request(Method.GET);

				
				String responseBody = response.getBody().asString();
				System.out.println("Response Body is =>  " + responseBody);
				JsonPath jsonPathEvaluator = response.jsonPath();
				
				int bookingID = jsonPathEvaluator.get("bookingid");
				 int roomID = jsonPathEvaluator.get("roomid");
				 String firstName = (String)jsonPathEvaluator.get("firstname");
				 String lastname = (String)jsonPathEvaluator.get("lastname");
				 String status = (String)jsonPathEvaluator.get("status");
				 System.out.println(firstName+""+status);
				 
				 
				 Assert.assertEquals(1, bookingID);
				 Assert.assertEquals(1, roomID);
				 Assert.assertEquals("James", firstName);
				 Assert.assertEquals("Dean", lastname);
		
	}
	
	@Test(priority=3)
	public void getBookings() {
		
				RestAssured.baseURI = "https://automationintesting.online/booking/";

				
				RequestSpecification httpRequest = RestAssured.given();

				
				Response response = httpRequest.request(Method.GET);
				
				 JsonPath jsonPathEvaluator = response.jsonPath();

				
				String responseBody = response.getBody().asString();
				System.out.println("Response Body is =>  " + responseBody);
                  
				
				int bookingID1 = jsonPathEvaluator.get("bookings.bookingid[0]");
				 int roomID1 = jsonPathEvaluator.get("bookings.roomid[0]");
				 String firstName1 = (String)jsonPathEvaluator.get("bookings.firstname[0]");
				 //String status = (String)jsonPathEvaluator.get("status");
				 System.out.println(firstName1);
				 
				 int bookingID2 = jsonPathEvaluator.get("bookings.bookingid[1]");
				 int roomID2 = jsonPathEvaluator.get("bookings.roomid[1]");
				 String firstName2 = (String)jsonPathEvaluator.get("bookings.firstname[1]");
				 //String status = (String)jsonPathEvaluator.get("status");
				 System.out.println(firstName2);
				 
				 
				 Assert.assertEquals(1, bookingID1);
				 Assert.assertEquals(1, roomID1);
				 Assert.assertEquals("James", firstName1);
				 
				 Assert.assertEquals(2, bookingID2);
				 Assert.assertEquals(2, roomID2);
				 Assert.assertEquals("string", firstName2);
		
	}
	
	
	
	
    
}