package passenger_testScenario;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;


public class createPassenger {
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI= "https://api.instantwebtools.net/v1";
	}
	
	//Create passenger data with correct passenger data
	
	@Test
	public void createAPassenger(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		
		data.put("trips", 100);
		
		data.put("airline", 5);
				
		String passengerId = given()
				.contentType("application/json")
				.body(data.toString())
				.when()
				.post("/passenger")
				.jsonPath()
				.get("_id");
		
			// Storing data in a context to use for other tests
			context.getSuite().setAttribute("_id", passengerId);
					
	}

}
