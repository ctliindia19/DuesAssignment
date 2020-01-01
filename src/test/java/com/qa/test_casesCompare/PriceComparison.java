package com.qa.test_casesCompare;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.amazonPages.AmazonProductPage;
import com.qa.amazonPages.AmazonSearchPage;
import com.qa.core.BaseClass;
import com.qa.flipkartPages.FlipkartProductPage;
import com.qa.flipkartPages.FlipkartSearchPage;
import com.qa.tripadvisorPages.TripadvisorClubPage;
import com.qa.tripadvisorPages.TripadvisorReviewPage;
import com.qa.tripadvisorPages.TripadvisorSearchPage;

public class PriceComparison extends BaseClass {
	
	@BeforeMethod
	public void browserSetup(){
		
		System.setProperty("webdriver.chrome.driver", "exefiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void testAmazon(){
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		AmazonSearchPage asp=new AmazonSearchPage(driver);
		asp.searchItem();
		wait(2);
		asp.selectSearchedItem();
		switchWindow();
		url_amazon = driver.getCurrentUrl();
		wait(3);
		AmazonProductPage app=new AmazonProductPage();
		app.getItemPrice();
		//driver.quit();
	}
	
	@Test(priority=2)
	public void testFlipkart(){
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		FlipkartSearchPage fsp=new FlipkartSearchPage(driver);
		fsp.closePopupFlipkart();
		wait(1);
		fsp.searchItemFlipkart();
		wait(2);
		fsp.selectSearchedItemFlipkart();
		switchWindow();
		url_flipkart = driver.getCurrentUrl();
		wait(3);
		FlipkartProductPage fpp=new FlipkartProductPage(driver);
		fpp.getItemPriceFlipkart();
		if(FlipkartProductPage.double_itemPrice > AmazonProductPage.double_itemPrice){
			System.out.println("Fllowing site having cheapest price: " +url_amazon+ " "+AmazonProductPage.double_itemPrice);
		}
		else {
			System.out.println("Following site having cheapest price: "+ url_flipkart + " "+FlipkartProductPage.double_itemPrice);
		}
	}
	
	@Test(priority=3)
	public void testTripadvisor(){
		driver.get("https://www.tripadvisor.in/");
		driver.manage().window().maximize();
		TripadvisorSearchPage tasp=new TripadvisorSearchPage(driver);
		tasp.searchClub();
		
		wait(3);
		TripadvisorClubPage tacp=new TripadvisorClubPage(driver);
		tacp.selectWriteReview();
		switchWindow();
		System.out.println(driver.getCurrentUrl());
		wait(2);
		TripadvisorReviewPage tarp=new TripadvisorReviewPage(driver);
		tarp.addRating();
		wait(2);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}

}
