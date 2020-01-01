package com.qa.amazonPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.core.BaseClass;

public class AmazonSearchPage extends BaseClass {
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchKey;
	@FindBy (xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']")
	private WebElement searchedItem;
	
	
	public AmazonSearchPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchItem(){
		searchKey.sendKeys("iPhone XR (64GB)-Yellow");
		searchKey.sendKeys(Keys.ENTER);
	}
	public void selectSearchedItem(){
		
		searchedItem.click();
	}
}
