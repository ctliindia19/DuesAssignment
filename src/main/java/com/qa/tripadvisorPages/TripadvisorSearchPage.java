package com.qa.tripadvisorPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.core.BaseClass;

public class TripadvisorSearchPage extends BaseClass{

	@FindBy(xpath="//span[text()='Search']")
	public WebElement searchBox;
	@FindBy(id="mainSearch")
	public WebElement searchKey;
	@FindBy(xpath="//div[@class='scopedSearchDisplay staticPOIDisplay']/ul[1]/li[1]/div[2]/div[1]/span")
	public WebElement searchedItem;
	
	public TripadvisorSearchPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void searchClub(){
		searchBox.click();
		wait(2);
		searchKey.sendKeys("Club Mahindra");
		wait(2);
		searchedItem.click();
	}
}
