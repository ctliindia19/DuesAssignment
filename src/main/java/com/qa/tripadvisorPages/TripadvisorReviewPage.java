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
	
	
	@FindBy(xpath="//div[@class='easyClear bigRatingParent']/span")
	public WebElement overallRating;
	@FindBy(xpath="//input[@id='ReviewTitle']")
	public WebElement reviewTitle;
	@FindBy(id="ReviewText")
	public WebElement yourReview;
	@FindBy(id="noFraud")
	public WebElement txt_chkBox;
	@FindBy(xpath="//div[text()='Hotel Ratings']")
	public WebElement hotelRatings;
	@FindBy(id="qid12_bubbles")
	public WebElement serviceRating;
	@FindBy(id="qid14_bubbles")
	public WebElement cleanlinessRating;
	@FindBy(id="qid11_bubbles")
	public WebElement roomsRating;
	
	
	public TripadvisorReviewPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void addRating(){
		//overallRatingValue=overallRating.getAttribute("data-value");
		overallRatingValue=overallRating.getAttribute("class");
//		String[] rating_data = overallRatingValue.split("_");
//		System.out.println(rating_data[2]);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('class','ui_bubble_rating fl bubble_50')", overallRating);
		selectByMouseClick(overallRating);
		
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
		selectCheckBox(txt_chkBox);
		
		if(isElementPresent(hotelRatings)==true){
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].setAttribute('class','answersBubbles ui_bubble_rating fl qid12 bubble_50')", serviceRating);
			selectByMouseClick(serviceRating);
			wait(1);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].setAttribute('class','answersBubbles ui_bubble_rating fl qid14 bubble_50')", cleanlinessRating);
			selectByMouseClick(cleanlinessRating);
			wait(1);
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].setAttribute('class','answersBubbles ui_bubble_rating fl qid11 bubble_50')", roomsRating);
			selectByMouseClick(roomsRating);
			
			
		}
		
	}

}

