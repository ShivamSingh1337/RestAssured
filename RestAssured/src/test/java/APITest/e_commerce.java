package APITest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;



public class e_commerce {
	public String accessToken;
	public String id;
	
	
	public static String baseurl = "https://ecommerceservice.herokuapp.com";
	
	@Test(priority = 0)
	public void sign_up()
	{
		RestAssured.baseURI = baseurl;
			
			String Requestbody ="{\n"
			+" \"email\":\"test1234@gmail.com\",\n"
			+"\"password\":\"test@123\"\n" 
			+"}";
	

//this time i want to know what my response is in my console

Response response = given()
.header("content-type","application/json")
.body(Requestbody)

.when()
.post("/user/signup")

.then()
.assertThat().statusCode(201).and().contentType(ContentType.JSON)
//TO extract the response
.extract().response();
//to print the response
//basically the outputformat by default wil be string  i can not read,ill convert to json
//if i want to  convert normal string to JSON
String jsonresponse =response.asString();
JsonPath responsebody =new JsonPath(jsonresponse);
System.out.println(responsebody.get("message"));
}


@Test(priority = 1)
public void Login()
{
	RestAssured.baseURI = baseurl;
		
		String Requestbody ="{\n"
		+" \"email\":\"test1234@gmail.com\",\n"
		+"\"password\":\"test@123\"\n" 
		+"}";


//this time i want to know what my response is in my console

Response response = given()
.header("content-type","application/json")
.body(Requestbody)

.when()
.post("/user/login")

.then()
.assertThat().statusCode(200).and().contentType(ContentType.JSON)
//TO extract the response
.extract().response();
//to print the response
//basically the outputformat by default wil be string  i can not read,ill convert to json
//if i want to  convert normal string to JSON
String jsonresponse =response.asString();
JsonPath responsebody =new JsonPath(jsonresponse);
System.out.println(responsebody.get("accessToken"));
}
@Test(priority = 2)
public void get()
{
	RestAssured.baseURI = baseurl;
		
		String Requestbody ="{\n"
		+" \"email\":\"test1234@gmail.com\",\n"
		+"\"password\":\"test@123\"\n" 
		+"}";


//this time i want to know what my response is in my console

Response response = given()
.header("content-type","application/json")
.header("Authorization","bearer"+accessToken)



.when()
.get("/user")

.then()
.assertThat().statusCode(201).and().contentType(ContentType.JSON)
//TO extract the response
.extract().response();
//to print the response
//basically the outputformat by default wil be string  i can not read,ill convert to json
//if i want to  convert normal string to JSON
String jsonresponse =response.asString();
JsonPath responsebody =new JsonPath(jsonresponse);
System.out.println(responsebody.get("users[177]._id"));
}
}

