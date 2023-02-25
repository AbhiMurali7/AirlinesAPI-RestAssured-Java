package airlines_testScenario;

import org.testng.annotations.Test;
import java.io.File;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class createAirline {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI= "https://api.instantwebtools.net/v1";
	}
	
	@Test
	public void createAirlineData(ITestContext context) {
		
		 File airlinerequest = new File("airlinerequest.json");
		 
		 String passengerId =  given()
		 .header("Content-Type", "application/json")
		 .when()
		 .body(airlinerequest)
		 .post("/airlines")
		 .jsonPath()
			.get("id");
		 
		// Storing data in a context to use for other tests
		context.setAttribute("id", passengerId);
		
	}
	
}
