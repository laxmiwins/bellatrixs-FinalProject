package com.cucumberproject.steps;

import java.util.List;

import org.testng.Assert;

import com.cucumber.pages.ProductPage;
import com.cucumberproject.base.Keywords;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomatioExcercisesSteps {
	Keywords keyword=new Keywords();
	ProductPage productpage=new ProductPage();
	@Given("Application is launched completely")
	public void launchAppUrl() {
	keyword.launchUrl("http://automationexercise.com");
	}
	@When("User searches Top in search component")
	public void searchProduct() {
		
		productpage.seachCategoryWomen();
	}
	 
	@Then("All results must contain Top word in the product title")
	public void validateSearchResult(){
		List<String> productTitles=productpage.getProductTitles();
		for(String productTitle:productTitles) {
			Assert.assertTrue(productTitle.contains("Top"),"product title does not contain Top");
		}
		
		
	}

	}
