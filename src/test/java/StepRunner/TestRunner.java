package StepRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="J:\\eclipse_Jdrive\\Cucumber_BDD_CI_CD\\src\\test\\java\\FeatureFile\\Login.feature",
		glue={"StepDefinition"},
		dryRun=false,
		monochrome=true,
		//tags="@regression", //scenarios under @sanity tag will be executed.
		plugin= { "pretty", "html:J:\\eclipse_Jdrive\\Cucumber_BDD_CI_CD\\target\\report12.html", 
				"json:J:\\eclipse_Jdrive\\Cucumber_BDD_CI_CD\\target\\SearchCustbyName.json"
		}
		
		
		
		
		
		)


public class TestRunner {

}
