package com.qa.tripadvisorPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.core.BaseClass;

public class TripadvisorClubPage extends BaseClass{
	
	@FindBy(xpath="//div[@class='hotels-community-content-common-ContextualCTA__currentOption--3Wd5D']/a")
	public WebElement writeReview;

	public TripadvisorClubPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void selectWriteReview(){
		javascriptexecutor(writeReview);
	}
}
