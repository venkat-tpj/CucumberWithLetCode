package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginString extends DriverInstance {

//	WebDriver driver;
//	WebDriverWait wait;
	
			@And("User Clicks Account Login Icon")
			public void userClicksAccountLoginIcon() {
			   driver.findElement(By.xpath("//span[text()='Login']")).click(); 
			}
				
			@Given("User enter username as {string}")
			public void userEnterUsernameAs(String username) {
				driver.findElement(By.cssSelector("input[formcontrolname='username']"))
				.sendKeys(username);
			}
		
			@Given("User enter password as {string}")
			public void userEnterPasswordAs(String password) {
				driver.findElement(By.cssSelector("input[formcontrolname='password']"))
				.sendKeys(password);
			}
			
			@When("User click on login icon")
			public void userClickOnLoginIcon() {
				driver.findElement(By.xpath("(//span[text()='Login'])[2]")).click();
			}
		
			@Then("Login should be positive")
			public void loginShouldBeSuccess() {
				driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")));
	//		    String text = driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")).getText();
	//		    System.out.println(text);
	//		    driver.quit(); moved to MyHooks class
			}
			
			@But("Login should be negative")
			public void loginShouldNotBeSuccess() {
				String text = driver.findElement(By.xpath("(//mat-error[@role='alert'])[1]")).getText();
				Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
	//			driver.quit(); moved to MyHooks class
			}
			/*
			@Given("User Navigate BookCart Application String")
			public void userNavigateBookCartApplicationString() {
			    driver= new ChromeDriver();
			    driver.get("https://bookcart.azurewebsites.net/");
			    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    driver.manage().window().maximize();
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				System.out.println(driver.getTitle());
			}*/
				//moved to MyHooks class
	
	

}
