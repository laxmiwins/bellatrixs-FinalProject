package com.cucumber.pages;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberproject.steps.TestBase;
import com.cucumberproject.utilities.FileUtil;
import com.cucumberproject.utilities.WaitFor;

public class ContactPage {
	
	@FindBy(css="#site-navigation > div:first-of-type > ul > li:nth-of-type(5) > a")
	WebElement contactForm;
	
	@FindBy(css="input#wpforms-3347-field_1")
	WebElement Fname;
	
	@FindBy(css="input#wpforms-3347-field_1-last")
	WebElement Lname;
	
	@FindBy(css="input#wpforms-3347-field_2")
	WebElement email;
	
	
	@FindBy(css="input#wpforms-3347-field_3_1")
	public WebElement Bronze;
	
	@FindBy(css="input#wpforms-3347-field_3_2")
	public WebElement silver;
	
	@FindBy(css="input#wpforms-3347-field_4_1")
	public WebElement Session1;
	
	@FindBy(css="input#wpforms-3347-field_4_2")
	public WebElement Session2;
	
	@FindBy(css="input#wpforms-3347-field_5_1")
	WebElement overnightyes;
		
	@FindBy(css="input#wpforms-3347-field_6_1")
	WebElement emailUpdate;
	
	@FindBy(css="textarea#wpforms-3347-field_7")
	WebElement comments;
	
	@FindBy(css="div.recaptcha-checkbox-border")
	WebElement captcha;
	
	@FindBy(css="button#wpforms-submit-3347")
	WebElement submit;
	
	@FindBy(css="label#wpforms-3347-field_2-error")
	WebElement emailValidation;
	
	@FindBy(css="#wpforms-confirmation-3347 > p")
	WebElement contactconfirmmsg;
	
	@FindBy(css="label#wpforms-3347-field_1-error")
	WebElement requiredFieldErrorMsg;
	
	FileUtil file=new FileUtil();
	WaitFor wait=new WaitFor();
	
	
	public ContactPage() {
		PageFactory.initElements(TestBase.getDriver(),this);
	}
	
	public void clickOnContactForm() {
		contactForm.click();
	}
	

	
	public void getRowFromExcel(String filePath, String sheetName, int rowNum) {
		
		Workbook book = null;
		try {
			book = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		
		
			//Cell cellData=row.getCell(i);
			String firstname=row.getCell(0).getStringCellValue();
			String lastname=row.getCell(1).getStringCellValue();
			String emailId=row.getCell(2).getStringCellValue();
			String comment=row.getCell(3).getStringCellValue();
			
			Fname.sendKeys(firstname);
			Lname.sendKeys(lastname);
			email.sendKeys(emailId);
			Bronze.click();
			Session1.click();
			overnightyes.click();
			comments.sendKeys(comment);
			
			
		}
	
		
	public void clickOnCaptcha() throws InterruptedException {
		TestBase.getDriver().switchTo().frame(TestBase.getDriver().findElement(By.xpath("//iframe[@title=\"reCAPTCHA\"]")));
		wait.withTimeout(Duration.ofSeconds(60));
		captcha.click();
		TestBase.getDriver().switchTo().parentFrame();
		wait.withTimeout(Duration.ofSeconds(120));
		
	}
	public void clickOnSubmit() {
		submit.click();
	}
	
	 public void isSelectTheRadioButton(WebElement element) {
	        element.click();
	 }
	 
	 public void selectCheckBoxes(WebElement element1,WebElement element2) {
		element1.click();
		element2.click();
		 
	 }
	 
	 
	
	public void FillContactForm() {
		//file.getRowFromExcel("C:\\Users\\DELL\\Desktop\\New folder\\cucumber setup\\ContactFormExcel.xlsx", "ContactFormData", 1);
		getRowFromExcel("C:\\Users\\DELL\\Desktop\\New folder\\cucumber setup\\ContactFormExcel.xlsx", "ContactFormData", 1);
		
	}
	public void FillTheContactForm() {
		getRowFromExcel("C:\\Users\\DELL\\Desktop\\New folder\\cucumber setup\\ContactFormExcel.xlsx", "ContactFormData", 2);
		
	}
	
	public void FillContactFormCorrectly() {
		getRowFromExcel("C:\\Users\\DELL\\Desktop\\New folder\\cucumber setup\\ContactFormExcel.xlsx", "ContactFormData", 3);
		
	}
	public void fillIncorrectemail() {
		getRowFromExcel("C:\\Users\\DELL\\Desktop\\New folder\\cucumber setup\\ContactFormExcel.xlsx", "ContactFormData", 4);
	}
}
	
	
	

