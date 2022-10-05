package TestCases;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import Base.BasePage;
import Base.BaseTest;
import Pages.HomePage;
import Pages.SearchResultPage;
import Utils.Constant;

public class CompareWord extends BaseTest 
{

	HomePage homePage;
	SearchResultPage searchResultPage;
	final static Logger logger = Logger.getLogger(BasePage.class); 
	
	@Test
	public void compareSearchedWord() 
	{
	homePage=new HomePage(driver,wait);
	searchResultPage=new SearchResultPage(driver,wait);
	
	homePage.clickSearchButton();
	boolean isAppear=homePage.isAppearedSearchArea();
	Assert.assertTrue(isAppear);
	logger.info(" Search Area Appeared Correctly!");
	homePage.searchWord(Constant.word);
	boolean isVerified= searchResultPage.verifySearchedWord();
	Assert.assertTrue(Constant.errorMesage, isVerified);
	logger.info("Match found. The word you searched for is present in all definitions");
	}
}
