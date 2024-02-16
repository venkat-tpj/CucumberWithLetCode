package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HeaderPage {

	PageContext context;
	
	public HeaderPage (PageContext context) {
		this.context = context;
	}
	
	@And("User Clicks Account Login Icon")
	public void userClicksAccountLoginIcon() {
	   context.getDriver().findElement(By.xpath("//span[text()='Login']")).click(); 
	}
	@Given("user search for a {string}")
	public void userSearchForA(String bookname) {
		context.getDriver().findElement(By.cssSelector("input[type='search']")).sendKeys(bookname);
		context.getDriver().findElement(By.cssSelector("span.mat-option-text")).click();
	}
	@Then("the cart badge should get updated")
	public void theCartBadgeShouldGetUpdated() {
		context.getDriver().findElement(By.xpath("//span[text()='One Item added to cart']"));
	    context.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='One Item added to cart']")));
		context.getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='One Item added to cart']")));
	    String text = context.getDriver().findElement(By.xpath("//span[@id='mat-badge-content-0']")).getText();
	    System.out.println(text);
//	    driver.quit();
	}
	
	
}
