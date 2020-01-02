package com.qa.tripadvisorPages;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.core.BaseClass;

public class TripadvisorReviewPage extends BaseClass {
	
	
	@FindBy(xpath="//span[@id='bubble_rating']")
	public WebElement overallRating;
	@FindBy(xpath="//input[@id='ReviewTitle']")
	public WebElement reviewTitle;
	@FindBy(id="ReviewText")
	public WebElement yourReview;
	@FindBy(xpath="//input[@class='checkbox']")
	public WebElement txt_chkBox;
	@FindBy(xpath="//div[text()='Hotel Ratings']")
	public WebElement hotelRatings;
	@FindBy(id="qid12_bubbles")
	public WebElement serviceRating;
	@FindBy(id="qid14_bubbles")
	public WebElement cleanlinessRating;
	@FindBy(id="qid190_bubbles")
	public WebElement sleepQuaRating;
	@FindBy(id="qid13_bubbles")
	public WebElement valueRating;
	@FindBy(id="qid11_bubbles")
	public WebElement roomsRating;
	
	
	public TripadvisorReviewPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void addRating(){
		//overallRatingValue=overallRating.getAttribute("data-value");
//		overallRatingValue=overallRating.getAttribute("class");
//		String[] rating_data = overallRatingValue.split("_");
//		System.out.println(rating_data[2]);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		//js.executeScript("arguments[0].setAttribute('class','ui_bubble_rating fl bubble_50')", overallRating);
//		js.executeScript("arguments[0].setAttribute('data-value','5')", overallRating);
//		selectByMouseClick(overallRating);
		System.out.println("Number of options = "+overallRating.getSize());
		getOffsetValue(overallRating,50,15);
		
//		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
//		
//		 //.executeScript(mouseOverScript, overallRating);
//		//s.executeScript("$('element_selector').hover();");
//		mouseHoverJScript(overallRating1);
//		
//		//ring s=overallRating.getAttribute("data-value");
//		
//		overallRatingValue=overallRating.getAttribute("class");
		
		reviewTitle.sendKeys("Excellent");
		yourReview.sendKeys("Excellent");
		
		
		if(isElementPresent(hotelRatings)==true){
			
			System.out.println("Number of options = "+serviceRating.getSize());
			getOffsetValue(serviceRating, 50, 15);
			wait(1);
			System.out.println("Number of options = "+roomsRating.getSize());
			getOffsetValue(roomsRating, 50,15);
			wait(1);
			System.out.println("Number of options = "+valueRating.getSize());
			getOffsetValue(valueRating, 50,15);
			wait(1);
			System.out.println("Number of options = "+cleanlinessRating.getSize());
			getOffsetValue(cleanlinessRating, 50,15);
			wait(1);
			System.out.println("Number of options = "+sleepQuaRating.getSize());
			getOffsetValue(sleepQuaRating, 50,15);
		}
		wait(1);
		selectCheckBox(txt_chkBox);
		
	}

}

