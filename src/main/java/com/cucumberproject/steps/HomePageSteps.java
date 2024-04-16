package com.cucumberproject.steps;




import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.pages.HomePage;
import com.cucumberproject.base.Keywords;
import com.cucumberproject.config.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	
	private static final Logger LOG = Logger.getLogger(Stepone.class);
	Configuration config=new Configuration();
	//HomePage homepage=PageFactory.initElements(TestBase.getDriver(), HomePage.class);
	HomePage homepage=new HomePage();
	Keywords keyword=new Keywords();
	@Given("Application url completely launched and user is on the home page")
	public void openAppUrl() {
		
		keyword.launchUrl(config.getAppUrl("beta"));
		
	}
	
	@When("user select the dropdown for sort by price: high to low")
	public void selectDropdownByValue() {
		homepage.selectDropdown();
		

}
	@Then("validate that prices of products gets sorted by high to low order")
	public void validateprice() {
		homepage.converStringToDouble();
	}

}