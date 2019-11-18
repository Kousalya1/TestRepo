package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="src/Features", glue= {"StepDefinition"})
//@Cucumber.Options(features = "src/Features", glue = { "StepDefinition" }, tags = { "@Test" })

public class Runner {

}
