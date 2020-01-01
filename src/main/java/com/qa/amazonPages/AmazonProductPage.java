package com.qa.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.core.BaseClass;

public class AmazonProductPage extends BaseClass {
	
	@FindBy(xpath="//div[@id='price']/table/tbody/tr[2]/td[2]/span[@id='priceblock_ourprice']")
	private WebElement itemPrice;
	public static double double_itemPrice;
	public static String txt_itemPrice="";
	
	public AmazonProductPage(){
		PageFactory.initElements(driver, this);
	}

	public void getItemPrice(){
		txt_itemPrice = itemPrice.getText();
		//System.out.println(txt_itemPrice);
//		txt_itemPrice.replace("₹", "");
//		txt_itemPrice.replace(",", "");
		double_itemPrice = Double.valueOf(txt_itemPrice.replace("₹", "").replace(",",""));
		System.out.println("Item price in Amazon: "+double_itemPrice);
//		String[] arrOfStr = txt_itemPrice.split("?", 2); 
//		  
//        for (String a : arrOfStr) 
//            System.out.println(a);
//		try{
//		float float_itemPrice=Float.parseFloat(txt_itemPrice.trim());
//		System.out.println(float_itemPrice);
//		System.out.println(txt_itemPrice);
//		}catch(Exception e){
//			System.out.println("Exception occured");
//		}
		
	}
}
