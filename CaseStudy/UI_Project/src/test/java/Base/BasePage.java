package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver, WebDriverWait wait)
	{
		this.driver = driver;
		this.wait = wait;
	}

	public void clickElement(By by) 
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		element.click();
	}

	public void sendKeys(By by, String value)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		element.sendKeys(value);
	}

	public void keyEnter(By by) 
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		element.sendKeys(Keys.ENTER);
	} 
 }