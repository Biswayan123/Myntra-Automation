package com.myntra.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myntra.qa.base.TestBase;
import com.myntra.qa.pages.MyntraHomePage;
import com.myntra.qa.pages.ResultsPage;

public class MyntraTest extends TestBase{
	
	MyntraHomePage myntraHomePage;
	ResultsPage resultPage;
	public MyntraTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		myntraHomePage = new MyntraHomePage();
	}
	
	@Test
	public void testcase() throws InterruptedException {
		resultPage = myntraHomePage.selectMenTshirt();
		resultPage.clickSearchIconForBrand();
		resultPage.SearchTextAndSelect("Van Heusen");
		String filter_name = driver.findElement(By.xpath("//div[@class='filter-summary-filter']")).getText();
		Assert.assertEquals(filter_name, "Van Heusen");
		resultPage.sortByHigherDiscount();
		Thread.sleep(3000);
		resultPage.displayResults();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
