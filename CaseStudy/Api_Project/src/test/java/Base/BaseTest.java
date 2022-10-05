package Base;

import org.junit.Before;
import static io.restassured.RestAssured.*;

public class BaseTest 
{

	  @Before
      public  void setup() 
	  {
		  baseURI = "https://gorest.co.in/public/v1";
	  }
}
