package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (
				features = {"src/test/java/feature/loginstring.feature"},
				dryRun= !true, //attributes
				snippets = SnippetType.CAMELCASE,
				monochrome= true, //To remove Junk Characters
				glue= {"hooks", "pages"}, //remove "steps"
		//		plugin= {"pretty", "html:CuStrreport"}
				plugin="com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		)

		public class RunLoginString extends AbstractTestNGCucumberTests {

		}
