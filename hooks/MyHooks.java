package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.PageContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;



public class MyHooks {
	
	private PageContext context;
	
				public MyHooks (PageContext context) {
					this.context = context;
				}

//	protected static WebDriver driver; moved to DriverInstance class
//	protected static WebDriverWait wait; moved to DriverInstance class
	
				
				@After("@cleanCart")
				public void cleanup (Scenario scenario) {
					context.getDriver().findElement(By.xpath("(//mat-icon[contains(@class,'mat-icon notranslate')])[3]")).click();
					WebElement cartItem = context.getDriver().findElement(By.xpath("//div[@class='docs-example-viewer-title-spacer']//h2[1]"));
					context.getWait().until(ExpectedConditions.visibilityOf(cartItem));
					context.getDriver().findElement(By.xpath("(//button[contains(@class,'mat-focus-indicator mat-elevation-z4')]//span)[1]")).click();
					String text = context.getDriver().findElement(By.cssSelector("mat-card-title.mat-card-title")).getText();
					Assert.assertEquals(text,"Shopping cart is empty");
					
					/* works for Cucumber version 7
					byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
					scenario.attach(screenshotAs, "image/png", scenario.getName());
					*/
					byte[] screenshotAs = context.getDriver().getScreenshotAs(OutputType.BYTES);
					scenario.embed(screenshotAs, "image/png");
					
					// Scenario methods:
					/*
					System.out.println("name: " +scenario.getName());
					System.out.println("ID: " +scenario.getId());
					System.out.println("URi: " +scenario.getUri());
					System.out.println("Lines: " +scenario.getLines());
					System.out.println("Tags: " +scenario.getSourceTagNames());
					System.out.println("Status: " +scenario.getStatus());
					*/
				}
				
				/*
				@Before(order=2)
				public void beforeScenarioOne() {
					System.out.println("I am in before scenario one");
				}
				*/
				@Before(order=1)
				public void beforeScenario (Scenario scenario) {
//					System.out.println("I am in before scenario");
					RemoteWebDriver driver= new ChromeDriver();
				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				    context.setDriver(driver);
				    context.setWait(wait);
				    context.getDriver().get("https://bookcart.azurewebsites.net/");
				    Options manage = context.getDriver().manage();
				    manage.window().maximize();
				    manage.timeouts().implicitlyWait(Duration.ofSeconds(10));
//				    System.out.println(driver.getTitle());
//					System.out.println(" Scenario name - Before Scenario: ");
//					System.out.println(scenario.getName());
				}
				
				@After
				public void afterScenario (Scenario scenario) {
					boolean failed = scenario.isFailed();
					System.out.println("is Failed ? "+failed);
					
					if(failed) {
						byte[] screenshotAs = context.getDriver().getScreenshotAs(OutputType.BYTES);
						scenario.embed(screenshotAs, "image/png");
						
						// Works for Cucumber version 7						
//						byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
//						scenario.attach(screenshotAs, "image/png", scenario.getName());
					}
					
					context.getDriver().quit();
				
				}
				/*
				@BeforeStep
				public void beforeStep (Scenario scenario) {
					byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
					scenario.embed(screenshotAs, "image/png");
				}
				
				@AfterStep
				public void afterStep (Scenario scenario) {
			
				} */
}
