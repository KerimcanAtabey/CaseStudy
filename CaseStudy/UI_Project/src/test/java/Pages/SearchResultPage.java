package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.BasePage;
import Objects.SearchResultPageObjects;

public class SearchResultPage extends BasePage
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public SearchResultPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
	}
	
	public boolean verifySearchedWord() 
	{
		List<WebElement> results = driver.findElements(By.className("item-description"));
		List<WebElement> highlightedWord = driver.findElements(By.xpath("//p[@class='item-description']//span[@class='highlighted'][1]"));
		WebElement element=driver.findElement(By.xpath("(//p[@class='item-description'])[1]"));
		clickElement(SearchResultPageObjects.cookie);
		js.executeScript("arguments[0].scrollIntoView();", element);
		return results.size()==highlightedWord.size();
	}
}
