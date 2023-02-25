package passenger_testScenario;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getAllPassengers {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI= "https://api.instantwebtools.net/v1";
	}

	@Test
			public void retrievePassenger() {
				
			Response passengerresponse = given()
					.pathParam("page", 0)
					.pathParam("size", 10)
				.when()
				.get("/passenger");	
				
				System.out.println("Passenger details:"  +passengerresponse.prettyPrint());
				
			}
}
