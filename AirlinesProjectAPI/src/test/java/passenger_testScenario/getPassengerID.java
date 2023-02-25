package passenger_testScenario;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;


import io.restassured.RestAssured;

public class getPassengerID {

	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://api.instantwebtools.net/v1";
	}

	// Read Passenger By Passenger ID

	@Test
	public void retrievePassenger(ITestContext context) {
		
		String passengerId = (String) context.getSuite().getAttribute("_id");

		given()
		.when()
		.get("/passenger/" + passengerId)
		.then()
		  .statusCode(200)
		  .log().all();

	}
}
