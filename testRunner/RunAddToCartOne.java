package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (
				features = {"src/test/java/feature/AddToCartOne.feature"}, //attributes
				dryRun= !true, //attributes
				snippets = SnippetType.CAMELCASE,
				monochrome= true, //To remove Junk Characters
				glue= {"hooks", "pages"}, // To extend steps folder to runner file
				// remove "steps"
				plugin="com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//				plugin= {"pretty", "html:reports/result.html"}
				//"json:reports/result.json", "junit:reports/result.xml"},
//				tags = {"@smoke And @reg", "@prod"}
		)

		public class RunAddToCartOne extends AbstractTestNGCucumberTests {
	

		}
