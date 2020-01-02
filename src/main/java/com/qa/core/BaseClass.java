package com.qa.core;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseClass {
	
	public static WebDriver driver;
	protected static String overallRatingValue;
	protected String url_amazon="";
	protected String url_flipkart="";
	
	public static void switchWindow()
	{
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Total number of windows available is = "+windows.size());
		Iterator<String> winIterator = windows.iterator();
		while(winIterator.hasNext())
		{
			String childWindow = winIterator.next();
			driver.switchTo().window(childWindow);
			System.out.println("We are in "+driver.switchTo().window(childWindow).getTitle() +" window.");
		}
	}
	public static void waitForPageLoaded() 
	{
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() 
        {
                    public Boolean apply(WebDriver driver) 
                    {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, 90);
            wait.until(expectation);
        } 
        catch (Throwable error) 
        {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
        
	}
	public void wait(int seconds) {
        try {
            synchronized (driver) {
                seconds = (seconds * 1000);
                driver.wait(seconds);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	public void javascriptexecutor(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
	public static void selectByMouseClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
    }

	 public void selectCheckBox(WebElement element)
	    {
	    	if(element.isSelected())
	    	{
	    		System.out.println("Check box is already selected");
	    	}
	    	else
	    	{
	    		element.click();
	    		
	    	}
	    	
	    }
	    public boolean isElementPresent(WebElement element){
	    	if (element.isDisplayed())
	    	{
	    		return true;
	    	}
	    	else if(!element.isDisplayed()){
	    		return false;
	    	}
	    	else{
			return false;
	    	}
	}
	    public void getOffsetValue(WebElement element, int x, int y){
	    	Actions action = new Actions(driver);
            //WebElement rating = driver.findElement(By.xpath("//span[@id='bubble_rating']"));
            /*Point pt = rating.getLocation();
            System.out.println("Location of element is = "+pt);
            System.out.println("X-Offset = "+pt.getX());
            System.out.println("Y-Offset = "+pt.getY());*/
            //System.out.println("Number of options = "+element.getSize());
            action.moveToElement(element).moveByOffset(x, y).click().build().perform();

	    }
}
