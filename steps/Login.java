//package steps;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.But;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class Login {
//
//	public WebDriver driver;
//		
//			@Given("User Navigate BookCart Application Login")
//			public void userNavigateBookCartApplicationLogin() {
//			    driver= new ChromeDriver();
//			    driver.get("https://bookcart.azurewebsites.net/");
//			    driver.manage().window().maximize();
//			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				System.out.println(driver.getTitle());
//			}
//			
//			@And("User Click Account LoginButton")
//			public void userClicksAccountLoginButton() {
//			   driver.findElement(By.xpath("//span[text()='Login']")).click(); 
//			}
//		
//			@And("user enter username as pwood")
//			public void userEnterUsernameAsPwood() {
//				driver.findElement(By.cssSelector("input[formcontrolname='username']"))
//				.sendKeys("pwood");
//			}
//		
//			@And("user enter password as Cucumber123")
//			public void userEnterPasswordAsCucumber123() {
//				driver.findElement(By.cssSelector("input[formcontrolname='password']"))
//				.sendKeys("Cucumber123");
//			}
//			
//			@Given("user enter username as pfern")
//			public void userEnterUsernameAsPfern() {
//			    driver.findElement(By.cssSelector("input[formcontrolname='username']"))
//				.sendKeys("pfern");
//			}
//		
//			@Given("user enter password as Cucumber123456")
//			public void UserEnterPasswordAsCucumber123456() {
//				driver.findElement(By.cssSelector("input[formcontrolname='password']"))
//				.sendKeys("Cucumber123456");
//			}
//		
//			@When("user clicks on loginbutton")
//			public void userClicksOnLoginButton() {
//				driver.findElement(By.xpath("(//span[text()='Login'])[2]"))
//				.click();
//			}
//		
//			@Then("Login should be successfull")
//			public void loginShouldBeSuccessfull() {
//				String text = driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")).getText();
//			    System.out.println(text);
//			    driver.quit();
//			}
//			
//			@But("Login should not be successfull")
//			public void loginShouldNotBeSuccessfull() {
//				String text = driver.findElement(By.xpath("(//mat-error[@role='alert'])[1]")).getText();
//				Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
//				driver.quit();
//			}
//	
//}
