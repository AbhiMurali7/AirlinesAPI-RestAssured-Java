package passenger_testScenario;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;

public class updateAPassenger {
	

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI= "https://api.instantwebtools.net/v1";
	}
	
	//Update passenger name by passenger ID.
	
		@Test
		public void updateWholePassenger(ITestContext context) {
			
			String passengerId = (String) context.getSuite().getAttribute("_id");
			
			Faker faker = new Faker();
			
			JSONObject patchJson = new JSONObject();
			
			patchJson.put("name", faker.name().fullName());
			
				given()
					.header("Content-Type", "application/json")
					.body(patchJson.toString())
				.when()
					.patch("/passenger/" +passengerId)
					.jsonPath()
					.get("_id");
			
		}

}


