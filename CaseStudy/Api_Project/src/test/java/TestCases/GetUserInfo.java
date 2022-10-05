package TestCases;

import org.junit.Test;
import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import java.util.List;

public class GetUserInfo extends BaseTest 
{
	Logger logger=Logger.getLogger(GetUserInfo.class);
	
	@Test
	public void getAndCompareInfoWithExpected()
	{
		Response response=RestAssured.get("/users");
		List<Integer> dataList = response.jsonPath().getList("data.id");
		
		for(int i=0;i<dataList.size()-1;i++)
		{
			String convertingStringDataList = String.valueOf(dataList.get(i));
			int digitSizeOfDataList=convertingStringDataList.length();
			
			assertNotSame(dataList.get(i),null);
			logger.info("id: "+dataList.get(i)+" and not null. Checking Is Successful!");
			assertSame(digitSizeOfDataList,4);
			logger.info("id: "+dataList.get(i)+" and id values are 4 digits. Checking Is Successful!");
		}
		logger.info("****************************");
		logger.info("Checkings Is Succesful.Test Passed!");
	}
}
