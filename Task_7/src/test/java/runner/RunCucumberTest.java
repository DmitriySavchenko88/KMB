package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        plugin = {"pretty"},
        tags = "",
        features = "src/test/resources/features",
        glue = "src/test/java/definitions"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {


}

