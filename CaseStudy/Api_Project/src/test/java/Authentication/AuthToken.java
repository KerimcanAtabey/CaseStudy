package Authentication;

import org.json.simple.JSONObject;
import CreatingBody.CreateBodyForUserInfo;
import Utils.ConstantAuthInfo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthToken 
{
	
	public static Response createUserWithAuth() 
	{	
		JSONObject request = new JSONObject();
		request =CreateBodyForUserInfo.fillUserInfo();
		String payload=request.toJSONString();
		RequestSpecification requestSpecification=
		RestAssured.given().header("Authorization",ConstantAuthInfo.authToken).
		contentType("application/json").
		body(payload);
		Response response=requestSpecification.post("/users");
		return response;
	}
}
