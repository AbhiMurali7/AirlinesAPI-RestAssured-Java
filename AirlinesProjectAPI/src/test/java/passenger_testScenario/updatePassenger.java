package passenger_testScenario;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;

public class updatePassenger {
	

	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI= "https://api.instantwebtools.net/v1";
	}
	
	//Update whole Passenger
	
		@Test
		public void updatewholePassenger(ITestContext context) {
			
			Faker faker = new Faker();
			
			JSONObject data = new JSONObject();
			
			data.put("name", faker.name().fullName());
			
			data.put("trips", 200);
			
			data.put("airline", 5);
			
			String passengerId = (String) context.getSuite().getAttribute("_id");
			
				given()
					.contentType("application/json")
					.body(data.toString())
				.when()
					.put("/passenger/" + passengerId)
				.then()
					   .statusCode(200)
					   .log().all();
			
			
		}
}
	

