package com.cucumber.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cucumberproject.steps.TestBase;

public class HomePage {

	
	@FindBy(css="select.orderby")
	WebElement selectBy;
	
	@FindBy(css="span.price")
	List<WebElement> allprices;
	
	List<Long> priceList=new ArrayList<>();
	
	
	public HomePage() {
		PageFactory.initElements(TestBase.getDriver(),this);
	}
	public void selectDropdown() {
		Select s=new Select(selectBy);
		s.selectByVisibleText("Sort by price: high to low");
	}
	
	 
	public void converStringToDouble() {
       try {
		for(WebElement p : allprices) {
				
				priceList.add(Long.valueOf(p.getText())); 
				
			}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
       for (int i = 0; i < priceList.size()-1; i++) {
           if (priceList.get(i) < priceList.get(i+1)) {
        	   Assert.fail("Not in high to low order");  
           }
         
       }
       
       }

	
//	public Boolean ascendingCheck(List<Double> data){      //generalize method lihiliy high to low order madhe element ahet ka check karayla   
//        for (int i = 0; i < data.size()-1; i++) {
//            if (data.get(i) < data.get(i+1)) {
//                return false;
//            }       
//         }
//         return true;
//     }
//       
//	public List<String> getPrices(){
//		List<String> prices=new ArrayList<String>();
//		for(WebElement price: allprices) {
//			prices.add(price.getText());
//			System.out.println(price);
//		}
//		
//		return prices;
//	}
	
	
}
