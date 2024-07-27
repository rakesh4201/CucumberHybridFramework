package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;

	@Given("User opens the application")
	public void user_opens_the_application() {
		driver=DriverFactory.getDriver();
	    
	}

	@When("User enters valid product {string} into search box filed")
	public void user_enters_valid_product_into_search_box_filed(String validProductText) {
	    homePage = new HomePage(driver);
	    homePage.enterProductIntoSearchBox(validProductText);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		searchPage=homePage.clickOnSearchButton();
	   
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct());
	    
	}

	@When("User enters invalid product {string} into search box filed")
	public void user_enters_invalid_product_into_search_box_filed(String invalidProdcutText) {
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(invalidProdcutText);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	
		Assert.assertEquals("There is no product that matches the search criteria.", searchPage.retrieveNoProductMessageText());
	   
	}

	@When("User donesnt enter any product name in search box filed")
	public void user_donesnt_enter_any_product_name_in_search_box_filed() {
		homePage= new HomePage(driver);
	}



}
