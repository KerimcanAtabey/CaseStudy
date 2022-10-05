package CreatingBody;

import org.json.simple.JSONObject;
import Utils.ConstantUserInfo;

public class CreateBodyForUserInfo
{
	
	public static JSONObject fillUserInfo() 
	{
	JSONObject request = new JSONObject();
	request.put("email",ConstantUserInfo.email);
	request.put("name",ConstantUserInfo.name);
	request.put("gender",ConstantUserInfo.gender);
	request.put("status",ConstantUserInfo.status);
	return request;
	}
}
