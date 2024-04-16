package com.cucumber.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberproject.steps.TestBase;

public class ProductPage {
	@FindBy(css="#accordian > div:first-of-type > div:first-of-type > h4 > a")
	WebElement women;
	
	@FindBy(css="#Women > div > ul > li:nth-of-type(2) > a")
	WebElement top;
	
	@FindBy(xpath="//div[@class=\"productinfo text-center\"]/p")
	List<WebElement> productTitles;
	
	public ProductPage() {
		PageFactory.initElements(TestBase.getDriver(),this);
	}
	public void seachCategoryWomen() {
		women.click();
		top.click();
		
	}
	
	public List<String> getProductTitles(){
		List<String> titles=new ArrayList<String>();
		for(WebElement productTitle: productTitles) {
			titles.add(productTitle.getText());
			
		}
		
		return titles;
	}

}

