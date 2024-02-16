package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (
				features = {"src/test/java/feature/login.feature"},
				dryRun= !true, //attributes
				snippets = SnippetType.CAMELCASE,
				monochrome= true, //To remove Junk Characters
				glue= {"steps"},
				plugin= {"pretty", "html:Cucumreport"}
		)

		public class RunLogin extends AbstractTestNGCucumberTests {
	

		}
