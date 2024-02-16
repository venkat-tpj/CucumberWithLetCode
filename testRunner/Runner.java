package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (
//				features = {"src/test/java/feature/AddToCartOne.feature"}, //attributes
				features = {"src/test/java/feature/login.feature"},
				dryRun= !true, //attributes
				snippets = SnippetType.CAMELCASE,
				monochrome= true, //To remove Junk Characters
				glue= {"steps"}  //, "hooks"}, // To extend steps folder to runner file
//				plugin= {"pretty", "json:reports/result.json", "junit:reports/result.xml"},
//				tags = {"@smoke And @reg", "@prod"}
		)

		public class Runner extends AbstractTestNGCucumberTests {
	

		}
