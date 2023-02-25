package airlines_testScenario;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class getAllAirlines {
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI= "https://api.instantwebtools.net/v1";
	}
	
	@Test
	public void getAllAirlinesData() {
		
		given()
		.when()
		.get("/airlines")
		.then()
		.log()
		.all();
		
	}

}
