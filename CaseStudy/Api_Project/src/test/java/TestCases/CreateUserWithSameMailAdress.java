package TestCases;

import org.junit.Assert;
import org.junit.Test;
import Authentication.AuthToken;
import Base.BaseTest;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

public class CreateUserWithSameMailAdress extends BaseTest 
{
	Logger logger=Logger.getLogger(CreateUserWithSameMailAdress.class);
	
	@Test
	public void createUserInfoWithSameInfo() 
	{
		  Response response=AuthToken.createUserWithAuth();
		  String message=response.jsonPath().getString("data.message");
		  logger.info("message: "+message);
			  
		  int statusCode=response.statusCode();
		  Assert.assertEquals(statusCode,422);
		  logger.info("StatusCode information returned as "+statusCode+" It did not return 201 and the user was not created as expected");
		  logger.info("Failed to create user as expected in Negative Test. Negative Test Passed!");
	}
}
