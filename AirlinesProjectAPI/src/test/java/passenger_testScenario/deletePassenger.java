package passenger_testScenario;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;


public class deletePassenger {
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI= "https://api.instantwebtools.net/v1";
	}
	
	@Test
	public void deleteAPassenger(ITestContext context) {
		
		String passengerId = (String) context.getSuite().getAttribute("_id");

		given()
		.when()
		  .delete("/passenger/" +passengerId)
		.then()
		  .statusCode(200)
		  .log().all();
	}

}
