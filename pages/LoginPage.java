package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.PageContext;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage {

	PageContext context;
	public LoginPage(PageContext context) {
		this.context = context;
	}
	@Given("User enter username as {string}")
	public LoginPage userEnterUsernameAs(String username) {
		context.getDriver().findElement(By.cssSelector("input[formcontrolname='username']"))
		.sendKeys(username);
		return this;
	}

	@Given("User enter password as {string}")
	public LoginPage userEnterPasswordAs(String password) {
		context.getDriver().findElement(By.cssSelector("input[formcontrolname='password']"))
		.sendKeys(password);
		return this;
	}
	@When("User click on login icon")
	public HomePage userClickOnLoginIcon() {
		context.getDriver().findElement(By.xpath("(//span[text()='Login'])[2]")).click();
		return new HomePage(context);
	}

	@Then("Login should be positive")
	public HomePage loginShouldBeSuccess() {
		WebElement userEle = context.getDriver().findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"));
	    context.getWait().until(ExpectedConditions.visibilityOf(userEle));
	    Assert.assertEquals(userEle.isDisplayed(), true);
	    return new HomePage(context);
//		    String text = driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")).getText();
//		    System.out.println(text);
//		    driver.quit(); moved to MyHooks class
	}
	
	@But("Login should be negative")
	public LoginPage loginShouldNotBeSuccess() {
		String text = context.getDriver().findElement(By.xpath("(//mat-error[@role='alert'])[1]")).getText();
		Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
		return this;
//			driver.quit(); moved to MyHooks class
	}
	@Given("user login into the application with {string} and {string}")
	public void userLoginIntoTheApplicationWithAnd(String username, String password) {
		new HeaderPage(context).userClicksAccountLoginIcon();
		this.userEnterUsernameAs(username).userEnterPasswordAs(password).userClickOnLoginIcon();
	}
	
}
