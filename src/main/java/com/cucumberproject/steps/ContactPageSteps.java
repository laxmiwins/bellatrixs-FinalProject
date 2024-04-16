package com.cucumberproject.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cucumber.pages.ContactPage;
import com.cucumberproject.base.Keywords;
import com.cucumberproject.config.Configuration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactPageSteps {
	
	private static final Logger LOG = Logger.getLogger(Stepone.class);
	Configuration config=new Configuration();
	ContactPage contactpage=new ContactPage();
	Keywords keyword=new Keywords();
	@Given("Application url completely launched and user is on the contact page")
	public void openAppUrl() {
		
		keyword.launchUrl(config.getAppUrl("beta"));
		contactpage.clickOnContactForm();
	}
	
	
	@When("User enter a name with numbers in the name field")
	public void user_enter_name_with_number() throws InterruptedException {
		contactpage.FillContactForm();
		contactpage.clickOnCaptcha();
		
	}
	
	@And("submit the contact form")
	public void SubmitForm() {
		contactpage.clickOnSubmit();
	}
	
	@Then("after submitting contact form user should see an error message indicating that Please enter valid name")
	public void after_submitting_contact_form_user_should_see_an_error_message() throws InterruptedException {
		Thread.sleep(5000);
		String contactconfirmmsg = keyword.getText("css", "#wpforms-confirmation-3347 > p");
		LOG.info(contactconfirmmsg);
		Assert.assertFalse(contactconfirmmsg.contains("Thanks for contacting us! We will be in touch with you shortly."),
				"Invalid name format,Please enter valid name");

	}
	
	@When("User enter a name with special characters in the name field")
	public void user_enter_name_with_special_characters() throws InterruptedException {
		contactpage.FillTheContactForm();
		contactpage.clickOnCaptcha();
		
	}
	
	@When("User enter a email with invalid email id in the email field")
	public void user_enter_a_email_with_invalid_email_id_in_the_email_field() throws InterruptedException {
		contactpage.fillIncorrectemail();
		contactpage.clickOnCaptcha();
	    
	}
	
	@Then("after submitting contact form user should see an error message indicating that Please enter a valid email address.")
	public void user_should_get_error_message() throws InterruptedException {
		Thread.sleep(5000);
		String invalidmailmsg = keyword.getText("css", "label#wpforms-3347-field_2-error");
		LOG.info(invalidmailmsg);
		Assert.assertTrue(invalidmailmsg.contains("Please enter a valid email address."),
				"Please enter valid email format");
		
	}
	
	@When("user click the \"Submit\" button without filling out the form")
	public void user_click_submit_button_without_filling_form() throws InterruptedException {
		
		contactpage.clickOnSubmit();
	}
	
	@Then("user should see an error message \"Please fill out all the required fields.\"")
	public void user_should_see_an_error_message() throws InterruptedException {
		Thread.sleep(5000);
		String requiredFieldErrorMsg = keyword.getText("css", "label#wpforms-3347-field_1-error");
		LOG.info(requiredFieldErrorMsg);
		Assert.assertTrue(requiredFieldErrorMsg.contains("This field is required."),
				"Please fill out all the required fields.");

	}
	
	@When("user fill in the contact form information correctly")
	public void user_fils_information_on_contact_form_correctly() throws InterruptedException {
		contactpage.FillContactFormCorrectly();
		contactpage.clickOnCaptcha();
		
	}
		@Then("user should see a confirmation message")
	public void user_should_see_confirmation_message() throws InterruptedException {
		Thread.sleep(5000);
		String contactconfirmmsg = keyword.getText("css", "#wpforms-confirmation-3347 > p");
		LOG.info(contactconfirmmsg);
		Assert.assertTrue(contactconfirmmsg.contains("Thanks for contacting us! We will be in touch with you shortly."),
				"Please fill all information correctly");

	}
	
	@When("user select one radio button")
	public void user_select_one_radio_button() {
		contactpage.isSelectTheRadioButton(contactpage.silver);
	}
	
	@And("then user select another radio button")
	public void user_deselect_that_selected_radio_button() {
		contactpage.isSelectTheRadioButton(contactpage.Bronze);
	}
	
	@Then("that radio button should be selected")
	public void that_radio_button_should_be_selected() {
       Assert.assertTrue(contactpage.silver.isSelected());
     }
	
	@Then("then first selected radio button should deselect")
	public void then_that_radio_button_should_not_be_selected() {
       Assert.assertFalse(contactpage.silver.isSelected());
     }
	
	@When("user select the checkboxes with labels Option 1 and Option 2")
	public void i_select_the_checkboxes_with_labels_and() {
	    contactpage.selectCheckBoxes(contactpage.Session1, contactpage.Session2);
	  
	}

	@Then("the selected checkboxes should be Option 1 and Option 2")
	public void the_selected_checkboxes_should_be_and() {
		Assert.assertTrue(contactpage.Session1.isSelected());
		Assert.assertTrue(contactpage.Session2.isSelected());
	}

}
