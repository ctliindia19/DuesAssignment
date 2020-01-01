package com.qa.flipkartPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.core.BaseClass;

public class FlipkartProductPage extends BaseClass {
	
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	public WebElement itemPrice;
	public static double double_itemPrice;
	public static String txt_itemPrice="";
	
	public FlipkartProductPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void getItemPriceFlipkart(){
		
		txt_itemPrice = itemPrice.getText();
		//System.out.println(txt_itemPrice);
		double_itemPrice = Double.valueOf(txt_itemPrice.replace("₹", "").replace(",",""));
		System.out.println("Item price in Flipkart: "+double_itemPrice);
	}

}
