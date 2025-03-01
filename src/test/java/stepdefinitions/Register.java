package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;
    RegisterPage registerPage;
	AccountSuccessPage accountSuccess;
	CommonUtils commonUtils;
	
	@Given("User navigates to Register account page")
	public void user_navigates_to_register_account_page() {
		driver=DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage=homePage.selectRegisterOption();
	    
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
	    commonUtils = new CommonUtils();
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmailAddressField(commonUtils.getEmailTimeStamp());
		registerPage.enterTelephoneField(dataMap.get("telephone"));
		registerPage.enterPasswordField(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
		}

	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
			registerPage.enterFirstName(dataMap.get("firstName"));
			registerPage.enterLastName(dataMap.get("lastName"));
			registerPage.enterEmailAddressField(dataMap.get("email"));
			registerPage.enterTelephoneField(dataMap.get("telephone"));
			registerPage.enterPasswordField(dataMap.get("password"));
			registerPage.enterConfirmPassword(dataMap.get("password"));
		
		}
	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		
		registerPage.selectPrivacyPolicy();
	    
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		registerPage.clickOnContinueButton();
	   
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		accountSuccess= new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", accountSuccess.AccountSuccessPageHeading());
	    
	}

	@When("user selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.selectNewsLetterOption();
		
	    
	}

	@Then("User should get warning about duplicate email address")
	public void user_should_get_warning_about_duplicate_email_address() {
		
		Assert.assertTrue(registerPage.getDuplicateEmailWarning().contains("Warning: E-Mail Address is already registered!"));
	   
	}

	@When("User doesnot enter any details into fields")
	public void user_doesnot_enter_any_details_into_fields() {
	    
	}

	
	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
		
	  Assert.assertTrue(registerPage.retrievePrivacyPolicywarning().contains("Warning: You must agree to the Privacy Policy!"));
	  Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.retrieveFirstNameWarning());
	  Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.retrieveLastNameWarning());
	  Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.retrieveEmailWarning());
	  Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.retrieveTelephoneWarning());
	  Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.retrievePasswordWarning());
	  }

		}

