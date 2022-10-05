package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.BasePage;
import Objects.HomePageObjects;

public class HomePage extends BasePage
{
	
	public HomePage(WebDriver driver, WebDriverWait wait) 
	{
		super(driver, wait);
	} 
	
	public void clickSearchButton()
	{
		clickElement(HomePageObjects.searchingIcon);
	}
	
	public boolean isAppearedSearchArea()
	{
		WebElement searchingText=driver.findElement(By.id("global-search"));
		return !searchingText.isDisplayed();
	}

	public void searchWord(String word) 
	{
		sendKeys(HomePageObjects.searchintText,word);
		clickElement(HomePageObjects.searchingButton);
	}
}
