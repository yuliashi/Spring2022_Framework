import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //this creates cucumber reports
        plugin = {"pretty", "html:Reports/Default/"},

        //This creates auto-method in CamelCase
        snippets = SnippetType.CAMELCASE,

        //path to your feature file
        features = {"src/test/resources"},

        tags = {"@Test27"},

        //Specify step definition package name
        glue = {"StepDefinition", "Web"}
)

public class TestRunner {


}
