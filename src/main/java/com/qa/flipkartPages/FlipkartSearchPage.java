package com.qa.flipkartPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.mustache.BaseChunk;

import com.qa.core.BaseClass;

public class FlipkartSearchPage extends BaseClass {
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	public WebElement searchKey;
	@FindBy(xpath="//div[@class='_3wU53n']")
	public WebElement searchedItem;
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	public WebElement closePopup;
	
	
	public FlipkartSearchPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	

	public void closePopupFlipkart(){
		closePopup.click();
	}
	public void searchItemFlipkart(){
		searchKey.sendKeys("iPhone XR (64GB)-Yellow");
		searchKey.sendKeys(Keys.ENTER);
	}
	
	public void selectSearchedItemFlipkart(){
		
		searchedItem.click();
	}

}
