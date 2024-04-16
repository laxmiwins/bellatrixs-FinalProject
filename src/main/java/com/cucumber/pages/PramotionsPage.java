package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberproject.steps.TestBase;

public class PramotionsPage {
	
	@FindBy(xpath="//a[contains(@href,\"welcome\")]")
	WebElement pramotions;
	
	@FindBy(css="button#couponBtn")
	WebElement coupn;
	
	
	public PramotionsPage() {
		PageFactory.initElements(TestBase.getDriver(),this);
	}
	
	
	public void clickOnPramotion() {
		pramotions.click();
	}
	
	public void clickOnCoupn() {
		coupn.click();
	}

}
