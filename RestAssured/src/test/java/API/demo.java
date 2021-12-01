package API;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class demo {
	
	public String id;
	//i am teaching you how the get method works
	//get board trello link - https://api.trello.com/1/boards/{id}
	
	public static String baseurl = "https://api.trello.com/";
	
	
	@Test(priority = 0)
	public void createboard() {
		RestAssured.baseURI = baseurl;
		
		 Response response = given().queryParam("key", "462a72736c5595176a1fb780cac8ce2c")
		.queryParam("token", "b38e936fc5ff4eb246fd827eb207a38ba13d03b0b79121db58d45ffb2646d559")
		.queryParam("name", "newboard").header("content-Type","application/json")
		
		.when()
		.post("/1/boards")
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		
		.extract().response();
		 String jsonresponse =response.asString();
		JsonPath responsebody = new JsonPath(jsonresponse);
		id = responsebody.get("id");
		System.out.println(id);
		
	}
	
	@Test(priority = 1)
	public void getboard()
	{
		
		//any time you have to work with rest assured first you have to load the baseurl
		
				RestAssured.baseURI= baseurl;
				
				//pre-requisites//parameter//header//cookies
				Response response = given().queryParam("key", "462a72736c5595176a1fb780cac8ce2c")
				.queryParam("token", "b38e936fc5ff4eb246fd827eb207a38ba13d03b0b79121db58d45ffb2646d559")
				
		 		//condition//different HTTP methods
				.when()
				.get("/1/boards/"+id)
				//basically checking response //applying assertion //assertion and response
				.then()
				.assertThat().statusCode(200).contentType(ContentType.JSON)
				
				.extract().response();
				 String jsonresponse =response.asString();
				 System.out.println(jsonresponse);			
				
	}
	
	@Test(priority = 3)
	public void deleteboard() {
		
		RestAssured.baseURI = baseurl;
		
		 Response response = given().queryParam("key", "462a72736c5595176a1fb780cac8ce2c")
		.queryParam("token", "b38e936fc5ff4eb246fd827eb207a38ba13d03b0b79121db58d45ffb2646d559")
		
		.when()
		.delete("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		
		.extract().response();
		 String jsonresponse =response.asString();
		 System.out.println(jsonresponse);
		
		
	}
}