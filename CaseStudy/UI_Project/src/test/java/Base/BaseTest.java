package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest 
{
	public WebDriver driver;
	public WebDriverWait wait;
	private String selectBrowser = "chrome";
    private String baseUrl = "https://www.lely.com/en";

        @Before
	    public  void init() 
        {
			if (selectBrowser.equalsIgnoreCase("chrome")) 
			{
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				options.addArguments("disable-infobars");
				driver = new ChromeDriver(options);
				driver.get(baseUrl);
				driver.manage().window().maximize();
				waitForTenSeconds();
			} 
			
			else if (selectBrowser.equalsIgnoreCase("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(baseUrl);
				driver.get(baseUrl);
				waitForTenSeconds();
			} 
		}
	
	   public void waitForTenSeconds() 
	   {
		 wait = new WebDriverWait(driver, 10);
	   }

	   @After
	    public void tearDown() throws InterruptedException
	   {
		   Thread.sleep(6000);
	        driver.quit();
	    } 
}
