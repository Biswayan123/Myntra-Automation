package com.myntra.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.qa.base.TestBase;



public class MyntraHomePage extends TestBase{
	
	@FindBy(xpath="//a[text()='Men']")
	WebElement MenSection;
	
	@FindBy(xpath="//a[@href='/men-tshirts' and text()='T-Shirts']")
	WebElement Tshirts;
	
	public MyntraHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ResultsPage selectMenTshirt() {
		Actions action = new Actions(driver);
		action.moveToElement(MenSection).build().perform();
		Tshirts.click();
		
		return new ResultsPage();
	}
	

}
