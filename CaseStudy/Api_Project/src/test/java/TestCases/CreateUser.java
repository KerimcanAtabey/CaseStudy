package TestCases;

import org.junit.Assert;
import org.junit.Test;
import Authentication.AuthToken;
import Base.BaseTest;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import org.apache.log4j.Logger;

public class CreateUser extends BaseTest 
{
	Logger logger=Logger.getLogger(CreateUser.class);
	
	@Test
	public void createAndCompareUserInfo() 
	{
	
		Response response=AuthToken.createUserWithAuth();
		response.then().log().body();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode,201);
		logger.info("User is Created");
		
		response.then().body("data.email",equalTo("kerimcan@gmail.com"));
		response.then().body("data.name",equalTo("testing"));
		response.then().body("data.gender",equalTo("male"));
		response.then().body("data.status",equalTo("active"));
		logger.info("Data sent correctly. User created as requested. Test successful!");
	}
}
