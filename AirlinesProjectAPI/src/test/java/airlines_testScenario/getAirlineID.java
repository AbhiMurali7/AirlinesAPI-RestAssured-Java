package airlines_testScenario;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class getAirlineID {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI= "https://api.instantwebtools.net/v1";
	}
	
	@Test
	public void getAirlineId(ITestContext context) {
		
		String airlineId = (String) context.getAttribute("id");
		
		given()
		.when()
		.get("/airlines/" + airlineId )
		.then()
		.log()
		.all();
		
	}
}
