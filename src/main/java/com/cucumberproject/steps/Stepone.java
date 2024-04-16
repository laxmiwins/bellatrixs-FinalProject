package com.cucumberproject.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucumber.pages.PramotionsPage;
import com.cucumberproject.base.Keywords;
import com.cucumberproject.config.Configuration;
import com.cucumberproject.utilities.WaitFor;

import io.cucumber.java.en.When;


public class Stepone {
	
	private static final Logger LOG = Logger.getLogger(Stepone.class);
	Configuration config=new Configuration();
	PramotionsPage pramotion=new PramotionsPage();
	Keywords keyword=new Keywords();

	@When("open app url")
	public void m1() throws InterruptedException {
		LOG.info("my file");
		LOG.error("First err");
		keyword.launchUrl("https://demos.bellatrix.solutions/");
		pramotion.clickOnPramotion();
		pramotion.clickOnCoupn();
	}

}
