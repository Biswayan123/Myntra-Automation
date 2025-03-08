package com.myntra.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.qa.base.TestBase;

public class ResultsPage extends TestBase {
	
	@FindBy(xpath="//input[@placeholder='Search for Brand']/..")
	WebElement searchIconBrand;
	
	@FindBy(xpath="//input[@type='text' and @placeholder='Search for Brand']")
	WebElement searchTextBrand;
	
	@FindBy(xpath="//input[@type='checkbox' and @value='Van Heusen']//parent::label")
	WebElement selectBrand;
	
	@FindBy(xpath="//div[@class='sort-sortBy']")
	WebElement SortBy;
	
	@FindBy(xpath="//label[text()='Better Discount']")
	WebElement highDiscount;
	
	public ResultsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickSearchIconForBrand() {
		searchIconBrand.click();
	}
	
	public void SearchTextAndSelect(String searchtext) throws InterruptedException {
		searchTextBrand.sendKeys(searchtext);
		Thread.sleep(3000);
		selectBrand.click();
	}
	
	public void sortByHigherDiscount() {
		Actions action = new Actions(driver);
		action.moveToElement(SortBy).build().perform();
		highDiscount.click();
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e) {
			return false;
			
		}
	}
	public void displayResults() {
//		List<WebElement> product = driver.findElements(By.xpath("//li[@class='product-base']"));
		List<WebElement> links = driver.findElements(By.xpath("//a[@target='_blank']"));
		
		for(int i=0;i<links.size()-1;i++) {
			int j=i+1;
			boolean striked_price = isElementPresent(By.xpath("//ul/li[" + j + "]/a/div[2]//span[1]/span[2]"));
			boolean discount_percentage = isElementPresent(By.xpath("//ul/li[" + j + "]/a/div[2]//span[@class='product-discountPercentage']"));
//			try {
//			WebElement strike_price = ((WebElement)product.get(i)).findElement(By.xpath("//span[@class='product-strike']"));
//			}catch(NoSuchElementException e) {
//				e.printStackTrace();
//			}
////			System.out.println("Product name is : " +j +" " +links.get(i).getText());
//			System.out.println("Link For Product :" +links.get(i).getAttribute("href"));
//			if(striked_price && discount_percentage) {
//				System.out.println("Price of Product is :" + price.get(i).getText());
////				System.out.println("Discount Price is :" + strike_price.));
//			}
//			else {
//				System.out.println("Discount Price and Percentage not availabe");
//				System.out.println();
//			}
			
			System.out.println("Link for Product : " + j + " " +links.get(i).getAttribute("href"));
			
			if(striked_price && discount_percentage) {
				WebElement ele1 = driver.findElement(By.xpath("//ul/li[" + j + "]/a/div[2]//span[1]/span[2]")); //strike
				WebElement ele2 = driver.findElement(By.xpath("//ul/li[" + j + "]/a/div[2]//span[@class='product-discountPercentage']")); // discount_per
				WebElement ele3 = driver.findElement(By.xpath("//ul/li[" + j + "]/a/div[2]/div[1]/span[1]/span[@class='product-discountedPrice']"));
				System.out.println("Discounted Price for Product : " +ele3.getText());
				System.out.println("Original Price : " +ele1.getText());
				System.out.println("Discount Percentage : " +ele2.getText());
				System.out.println();
			}
			else {
				WebElement ele4 = driver.findElement(By.xpath("//ul/li[" + j + "]/a/div[2]/div[@class='product-price']"));
				System.out.println("Product Price : " +ele4.getText());
				System.out.println("Discount not available on this item");
				System.out.println();
			}
		}
	}

	

}
