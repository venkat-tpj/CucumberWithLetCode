package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.DriverInstance;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCartOne extends DriverInstance {

//	WebDriver driver;
//	WebDriverWait wait;
			/*
			@Given("User navigate BookCart Website")
			public void userNavigateBookCartWebsite() {
			    driver= new ChromeDriver();
			    wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			    driver.get("https://bookcart.azurewebsites.net/");
			    driver.manage().window().maximize();
			}
			*/
	
			@Given("user login into the application with {string} and {string}")
			public void userLoginIntoTheApplicationWithAnd(String username, String password) {
				driver.findElement(By.xpath("//span[text()='Login']")).click();
				driver.findElement(By.cssSelector("input[formcontrolname='username']"))
				.sendKeys(username);
				driver.findElement(By.cssSelector("input[formcontrolname='password']"))
				.sendKeys(password);
				driver.findElement(By.xpath("(//span[text()='Login'])[2]")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")));
				String text = driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")).getText();
				System.out.println(text);
			}
			
			@Given("user search for a {string}")
			public void userSearchForA(String bookname) {
			    driver.findElement(By.cssSelector("input[type='search']")).sendKeys(bookname);
			    driver.findElement(By.cssSelector("span.mat-option-text")).click();
			}
			
			@When("user add the book to the cart")
			public void userAddTheBookToTheCart() {
				driver.findElement(By.xpath("(//button[@color='primary']//span)[1]"));
				WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@color='primary']//span)[1]")));
				cartIcon.click();
			}
			
			@Then("the cart badge should get updated")
			public void theCartBadgeShouldGetUpdated() {
				driver.findElement(By.xpath("//span[text()='One Item added to cart']"));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='One Item added to cart']")));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='One Item added to cart']")));
			    String text = driver.findElement(By.xpath("//span[@id='mat-badge-content-0']")).getText();
			    System.out.println(text);
//			    driver.quit();
			}

}
